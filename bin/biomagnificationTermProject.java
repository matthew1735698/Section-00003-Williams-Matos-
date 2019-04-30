/** Term Project Winter 2019 
	Coded by: Matthew Williams and Alexandra Matos
*/
// Import required packages
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import org.math.plot.*;
import org.math.plot.plotObjects.*;
import java.util.Arrays;

public class biomagnificationTermProject {


	// Array storing the N15 values for each organism within the trophic levels, data collected from research
	public static final double[] N15 = {0.0, 0.0, 5.41, 5.75, 5.75, 8.13, 7.11, 7.11, 9.83, 12.21, 12.55, 11.87, 10.85, 0.0};

	// Array storing the average BMF values of each trophic levels
	public static final double[] BMF = {0.393, 17.435, .17};

	
	public static double planktonAbsorption(double MeHgInWaterFormula, double planktonsize) {
		
		return 1000*1.692*Math.pow(planktonsize,-0.344)*MeHgInWaterFormula*0.1;
	
	}
	
	public static double trophicFunction(double Nitrogen15) {
		
		return 1+((Nitrogen15 +0.03)/3.40);
	
	}
	
	
public static void main(String[] args) {
	
	// opening file to store data points
	
	String filename = "Simulation Biomagnification.txt";
        PrintWriter outputFile = null;
        try
        {
            outputFile = new PrintWriter(new FileOutputStream(filename,false));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File error.  Program aborted.");
            System.exit(0);
        }


/** Initialize time-step, total length of simulation, the initial concentration of MeHg in each organism, 
 the different rates of change, arrays for storing toxicity levels over time, and the concentration of Hg
*/

	double timeStep = 0.1;             
	double simulationLength = 100;                                                   // Length of the simulation (in days)
	double currentYear = 219;  
	double MeHgInitial = 0.001927;                                                   // pcg/L of mercury in 1800s 
	double MeHgInWaterFormula = MeHgInitial*Math.pow(10, (0.01589*currentYear));     // Magnification factor comparing concentration of MeHg in organisms vs water through bioaccumulation    
    double MeHgofT1 = 0;
    double MeHgofT2 = 0;                                                             // Initializing the variables for the different trophic levels
	double MeHgofT3 = 0;
	double MeHgofT4 = 0;  
    double netPlanktonsizeT1 = 	88E-6;
    double netPlanktonsizeT2 = 	875E-6;
	double MeHgofT1andT2 = MeHgofT1 + MeHgofT2; 
	
	


//  Write out each of the differential equations & Euler's method
		int N = (int) (simulationLength/timeStep) + 1;  
	
			for (int l = 1; l < N; l++) {
		
				MeHgofT1 = planktonAbsorption(MeHgInWaterFormula, netPlanktonsizeT1);
				
				MeHgofT2 = planktonAbsorption(MeHgInWaterFormula, netPlanktonsizeT2);
				
				MeHgofT3 = MeHgofT3 + (BMF[1] * MeHgofT1andT2 * timeStep);

				MeHgofT4 = MeHgofT4 + (BMF[2] * MeHgofT3 * timeStep);
             
				MeHgofT1andT2 = MeHgofT1 + MeHgofT2; 
			    
				currentYear++;

			}

		// converts concentration from picograms/L to nanograms/gram

		double MeHgngwgT1 = MeHgofT1*0.0000001;
		double MeHgngwgT2 = MeHgofT2*0.0000001;
		double MeHgngwgT3 = MeHgofT3*0.0000001;
		double MeHgngwgT4 = MeHgofT4*0.0000001;

		System.out.println("The average level of MeHg at T4 in ng/g is : " +MeHgngwgT4);
		System.out.println("The average level of MeHg at T3 in ng/g is : " +MeHgngwgT3);
		System.out.println("The average level of MeHg at T2 in ng/g is : " +MeHgngwgT2);
		System.out.println("The average level of MeHg at T1 in ng/g is : " +MeHgngwgT1);
		
		

		//Print final values to file
	    outputFile.printf("%6.1f\t%6.1f\t%6.1f\t%6.1f", MeHgofT1, MeHgofT2, MeHgofT3, MeHgofT4);

		// Trophic level based on the concentratoin of N15 in a subset of organisms from the Bay of Fundy 

		double[] TL = new double[13];
	
		for (int i = 0; i < TL.length && i <= N15.length; i++) {
		
		double tlevel = trophicFunction(N15[i]);	
		double roundedtlevel = Math.round (tlevel*100)/ 100.0;
		TL [i] = roundedtlevel;
		
		outputFile.printf("%6.1f\n",TL[i]);
		
		}
	
	
	outputFile.close();
	
	// Converting the trophic level of the organisms that was calculated to estimated MeHg concenctrations
	
	double[] MEHG = new double[13];
	
	for (int i = 0; i < MEHG.length; i++) {
		
		double mehg = 0.0105*Math.pow(euler(), TL[i]*1.6839);
		MEHG[i] = mehg;
		System.out.println("MeHg of orgnanism "+i+" " +MEHG[i]);
		System.out.println(" ");
		System.out.println("Trophic level of organism "+i+" " +TL[i]);
		System.out.println(" ");
		System.out.println(" ");
	}
}
	public static double euler() {

    double e = 0;
    double etemp = 1;
    for (int i = 1; i < 400; ++i) {
        e += etemp;
        etemp /= i;
    }
	return e;
	}
	  
	  }
	  
	



