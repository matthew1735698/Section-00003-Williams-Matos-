# Report
<pre>
Intro to Computer Programming

Alexandra Matos and Matthew Williams

Wednesday, May 22nd, 2019
</pre>
# Biomagnification of MeHg through trophic levels in the Bay of Fundy


### Introduction

For our term project, we decided to study the effects of methylmercury (MeHg) biomagnification through different trophic levels of marine animals located in the Bay of Fundy. Due to the large surface area of certain aquatic organisms such as phytoplankton, MeHg, a compound of Mercury, is easily absorbed and subsequently transferred up the trophic chain through prey consumption and/or female to offspring transfer. Furthermore, MeHg is also more easily transferable up the trophic chain than inorganic mercury. Seeing as though the consumption of fish and seafood amongst humans is at an all-time high, we decided to ask the question: what initial amount of MeHg in a primary producer would eventually lead -- through biomagnification -- to human neurotoxicity if consumed? By using the trophic levels of different organisms, their average mass, amount consumed, as well as birth and death rates all while taking account the total magnification factor (dependent on their zone), we plan to computationally calculate the amount of bioaccumulated MeHG in organisms of the highest trophic order.


###  Test case

The values of this computational model are based on the research article “Bioaccumulation of methylmercury within the marine food web of the outer Bay of Fundy, Gulf of Maine” by Gareth Harding, John Dalziel, and Peter Vass. The scientific paper discusses the relationship between different trophic levels, size of organisms within the trophic levels and most importantly, the concentration of methylmercury (MeHg) found in the organisms. 

In our project, we look to duplicate the final results through differential equations. This model can be applied to instances in which methylmercury has been introduced into an ecosystem and is transferred between organisms of different trophic levels through predator to prey consum

### Description of Model

Seeing as though the foundation of this term project is based on the Methylmercury levels in the bay of fundy, the following equation will be used to account for the slow but constant increase in the toxin levels due to outer sources (fossil fuels, mining, etc.). In order to create this equation, mercury levels from the pre-industrial revolution era were used to create an exponential function that related the increase of mercury levels due to each passing year. 

 
 ![First Equation](number1.png)
 
Primary producers such as plankton and phytoplankton are able to absorb and adsorb the MeHg found in their surrounding aquatic environment. Therefore, we must take into account their size to volume ratio which in turn relates to the total amount of MeHg that can be held within their system. In order to obtain the appropriate values, we must take into account the surface area of the planktons. With values from the scientific paper, we constructed an exponential function that relates surface area of primary producer to the absorption rate. In order to calculate the concentration within the primary producer the following equation is used:


 ![Second Equation](number2.png)

In order to calculate the final measurement of biomagnification within the organisms, we must first calculate the trophic levels of organisms. Using the δ15N of the organism (found in studies), we use the following equation to calculate the trophic level:

![Third Equation](number3.png)

By using the experimental isotopic biomagnification factor found in “Bioaccumulation of methylmercury within the marine food web of the outer Bay of Fundy, Gulf of Maine”, the following formula is used to calculate the biomagnification through trophic levels.

 ![Fourth Equation](number4.png)

### The science behind the biomagnification of Mercury and its compounds.

Mercury is a chemical element that exists in many forms. While this element can occur naturally, the post-industrial revolution era has caused a rise in its levels throughout our environment. Currently, our aquatic ecosystems are suffering due to the abnormal amount of mercury (and it’s compound forms) seeping into lakes, rivers and oceans.


#### *How mercury is accumulated in the environment?*

There are three main ways Mercury is introduced into an environment. Mercury can be released into the environment through natural occurrences, such as volcanoes, forest fires and the weathering of rocks. Mercury can also be released into the environment through non-natural sources, mainly the mining and burning of fossil fuels. Finally, mercury also experiences a cyclic reintroduction into the environment through the vaporization and condensation of water.  

When a compound of mercury enters an ecosystem, it is absorbed or adsorbed by an organism. This organism becomes a carrier of the element and can transfer it to other organisms through prey consumption as well as transfer from mother to offspring.

#### *The difference between absorption and adsorption*

**Absorption** is a process in which a substance is gradually accumulated within another substance or organism. This process occurs at a uniform rate and maintains a stable concentration throughout the material. Temperature does not affect this process.  

**Adsorption** is a process in which a substance accumulates at the surface of another substance or organism. Unlike absorption, adsorbed substances remain only on the exterior of another surface. This rate of this process slowly increases until equilibrium is reached. Furthermore, low temperature does affect the rate of reaction.


#### *The difference between biomagnification and bioaccumulation*
 
**Biomagnification** describes the large increase in the concentration of mercury between trophic levels. This gap is created by the prey (in the lower trophic level) being consumed by the predators (residing in the upper levels). As the predators consume the prey, they also ingest their mercury, thus increasing their concentration of mercury with every bite. 

**Bioaccumulation** occurs mainly at the first and second trophic levels, where primary producers are exposed to substances like mercury and they ingest it either through absorption or adsorption. 


### Description of Computational Method

In order to simulate biomagnification through organisms of different trophic levels, numerical methods were used. The constants used within the equations were taken from real-life data documented by scientific papers. The initial levels of MeHg were calculated through the use of a simple system of equations.  By taking into account the initial MeHg levels in the Bay of Fundy area pre-industrial revolution, an equation calculating the final MeHg concentration was built using the time (in years) as the variable. 

 ![Values](number5.png)
 
To begin, a differential equation is used to calculate the final level of Methylmercury found in the water. We include this calculated value in the next differential equation: the measurement of the amount of MeHg (in nm/g) in primary producers, specifically micro and macro-plankton. The following formula is used to calculate the trophic levels based on the experimental isotopic biomagnification levels. 

Next, we use our modified SIR model to calculate an estimate of the MeHg levels at each trophic level of this ecosystem. Using this data, we plotted a trophic level vs MeHg graph and got the equation describing the exponential relationship between the increase in trophic level and the rapid increase in MeHg concentration.

We can then use the formula seen below that we found in our research to determine the expected trophic level for each organism in our test set, using only the concentration of the Nitrogen 15 isotope found in them. Then we can plug the trophic level values for each individual organism into the exponential function we derived from the average MeHg at each trophic level (from the SIR model)  to find their estimated MeHg concentration. Now we have values derived from our model for the concentration of MeHg for each organism, and all we needed was the N15 concentration from them, an estimate of the biomagnification factors in the food chain, and the initial concentration of MeHg in the water. The latter of the two are very easily assumed in cases where minimal research has been done as MeHg concentrations are well documented in most areas and biomagnification factors are often similar in similar environments.


### Results

The simulated results drifted from the expected range so drastically the higher the trophic levels got because the biomagnification factors that dictate the rate of ingestion of MeHg became less representative of the trophic levels due to less data being available to us.

In terms of results, we compared our computational values to the results found in the journal  “Bioaccumulation of Methylmercury within the Marine Food Web of the Outer Bay of Fundy, Gulf of Maine”. While comparing all values found in the journal would be impossible due to the lack of data pertaining to the organisms of higher trophic level, we do see our data following an exponential increase, which mimics the researchers’ findings. The resulting graph of our computational project does show a deviation between our results (those in green) and those of the journal (those in blue), however, this difference can be attributed to the substantially large percent error. Furthermore, when taking into account the toxicity due to methylmercury levels within organisms (in ng/g), we can see that the concentrations, in 2018, become toxic to humans after approximately a trophic level of 3.7.

 ![Comparing Our Values to research values](thecomparegraph.png)
 
 
  ![Human toxicicity](toxiclevelgraph.png)
  
  The percent error of our model when compared to the data taken in the field by the researchers is significant. This error stems from the issues with our approach to modeling this issue. Firstly, since we did not have access to any sort of data on the feeding and mating habits of the animals in the Bay of Fundy or even an approximation of that data, we had to settle for using the biomagnification factors outlined in the study from which we used our model organisms. These biomagnification factors, while useful on an individual basis, were not representative for an entire trophic level. In hindsight this may seem obvious, as many organisms, even within the same trophic level, vary greatly in size and in MeHg concentration, but this was the only viable way of modelling the ecosystem with the available data. Using these biomagnification factors as a rate of change for every trophic level, our results showed a significantly more delayed magnification of the MeHg levels as the trophic level increased, ranging from 3% error for some organisms to over 80% error for others.   
  
| Organism | MeHg Concentrations (ng/g) - Computational Values|  MeHg Concentrations(ng/g) - Research Values|Percent Error (%)|
| ------------- |:-------------:| :-------------: |:-------------:|
| 1         | 0.057518938406336| 0.09        | 36.09|
| 2          | 0.057518938406336| 0.05       | 15.04|
| 3           | 0.836741563      | 0.4       |109|
| 4           | 0.990198331     | 0.5      | 98.0|
| 5          | 0.990198331     | 5.1      | 80.59|
| 6          | 3.21838595663203 | 5.3        | 39.4|
| 7           | 1.941983703| 6.9       | 71.88 |
| 8           | 7.469514309      | 17.4         |57.07|
| 9          |24.2777423560867      | 83.9         |71.06|
| 10          | 28.7302328630565 | 54.6         | 47.38|
| 11           | 20.5152800785835| 27.1         | 24.32|
| 12          | 12.3789813031645      | 27.1         | 55.72|




### Discussion

Similarly to the results from the scientific journal, our results show an exponential increase of methylmercury levels within an organism based on the trophic level. This confirms that our mathematical model was logically sound, as it did in fact follow the expected trend, however it would still require added layers of complexity and more detailed data to be a viable model for estimating the concentrations of MeHg in ecosystems similar to the Bay of Fundy. 

While the journal focuses on different aspects including the spherical diameter of organisms as well as both MeHg and THg levels, our focuse lay solely on trophic levels and bioaccumulated methylmercury. We restricted our computational model to the concentration of methylmercury and trophic levels due to the lack of other experimental data that could be used to substantiate results yielded from testing other variables like spherical diameter. 

In all, our computational model did solve our problem; it helped visually represent the increase of MeHg concentration through trophic levels specific to the Bay of Fundy. 


### *References*


Harding, Gareth, et al. “Bioaccumulation of Methylmercury within the Marine Food Web of the Outer Bay of Fundy, Gulf of Maine.” PloS One, Public Library of Science, 16 July 2018, www.ncbi.nlm.nih.gov/pmc/articles/PMC6047777/.

“Why Is There So Much Mercury in Marine Food Webs? Plankton Communities Are the First Step in Bioaccumulation.” Nereus Program - The Nippon Foundation, Nereus Fellow Colin Thackray, 2 Oct. 2018, www.nereusprogram.org/works/why-is-there-so-much-
Mercury-in-marine-food-webs-plankton-communities-are-the-first-step-in-
bioaccumulation/.

New Hampshire Department of Environmental Services. “Mercury: Sources, Transport, Deposition, and Impacts.” Environmental Fact Sheet, 2003,www.des.nh.gov/organization/-
commissioner/pip/factsheets/ard/documents/ard-28.pdf

“Metal, PCB, Dioxin and Furan Concentrations in Fish and Sediments from Four Lakes in Nord-Du-Québec in 2001.” Metal, PCB, Dioxin and Furan Concentrations in Fish and Sediments from Four Lakes in Northern Quebec in 2001, www.environnement.gouv.qc.ca/-
eau/eco_aqua/chibougamau/index-en.htm.

