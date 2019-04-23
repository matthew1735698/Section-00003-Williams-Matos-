# Code

Place the code you developped for the term project in this folder. Add any instructions/documentation required to run the code, and what results can be expected in this *README* file.

The code, as of now, is able to estimate the level of MeHg (Methyl Mercury) in a given aquatic organism based on its trophic level. (Assuming the biomagnification factors are given)

It also takes the N15 (Nitrogen 15, data that has been collected experimentally from a study done in the Bay of Fundy) values of some organisms and generates their trophic level. With this data and a trendline from the data we got from estimating MeHg, we can accurately estimate the level of MeHg of an organism in an aquatic environment from just their concentration of N15. 

The next step is finding a way to generalise this code in order to be more applicable in all cases (not just with the Bay of Fundy) and to add plotting functionanily, wherein the user will be able to visually see where the sample organisms lie in the graph of Trophic level vs MeHg concentration. Generalising this code might not be an achievable goal, as BMF values can change from one environment to another and different chemicals can interact with the environment in different ways (different levels of toxicity, etc). Finally, in order for the simulation to be as realistic as is feasibly possible, somehow working in the size of the sample organisms at each trophic level could bring an added perspective to the otherwise uncontextualised data.
