
## IGN CODE FOO ENGINEERING INTERNSHIP APPLICATION


**Introduction/Submission Details**:

I am a senior in high school submitting an Android mobile app and back end project as part of my application. I discovered this program the night before the deadline and so I spent most of Saturday working on both projects to the best of my ability. 

I completely finished both parts of the back end option. I was able to successfully complete half of the required tasks from the mobile application section. I ran into some issues rendering data from the API onto the activities on my mobile application. However, I did manage to successfully extract the information from the API and store it in Android Studio and develop the user interface of the app (i.e., the app bar and tab layout on top of the screen). 

Given a bit more time, I am confident I would have been able to finish the mobile application portion as well. This was a fantastic opportunity for me to learn more about backend technologies and some other features in Android development that I was not exposed to before. 


---

**Question 1**: Introduce yourself, explain your connection to IGN, and tell us why we should pick you to participate in IGN’s Code Foo program. Show your enthusiasm and passion for IGN in the form of a YouTube/Vimeo video, written document, audio track, or whatever format you feel most comfortable with.

**Answer 1**: My name is Anubhav and I have been an avid viewer of the IGN snapchat stories. (I only stopped recently because I uninstalled Snapchat in an effort to reduce my screen time). Also, as a kid, I would always visit the IGN site for clues and guides on defeating different bosses in different games like Sephiroth in Kingdom Hearts or the solution to some statue puzzles in Uncharted.

The reason I think I would be a good fit for IGN's Code Foo program is because I love to code, learn new technologies, quick to learn new things and love to game. Unfortunately, I only found about this program the night before the deadline but I have been coding non-stop to get something together to submit. I am currently a senior in high school and am looking to major in computer science in college and improve as much as I can as a developer. I know I am young and have a lot to learn but that is exactly why I think I can thrive at IGN.

---

**Question 2**: Hisui's New Power Plant

Requested By: Professor Laventon

The Galaxy Team has decided that in order to advance the research on Pokemon and the Pokedex, Jubilife village needs a brand new power plant. Luckily, Professor Laventon has discovered that the Pokemon, Voltorb, is the best candidate to help power the village.

Voltorbs can cleanly and efficiently produce electricity. An average Voltorb is about 0.5m (1'08") tall and weighs 10.4 kg (22.8lbs). However, they are uncommon and are only found in the Sacred Plaza.

Objective: How many Voltorbs will you need to catch to fully power the village. Describe each step in your thought process.


**Answer 2**: 11-12 Voltorbs to be safe.

**Assumptions**:
0. **Anime vs Video Game**: From the link provided, the population in the anime is much bigger than the video game. For sake of simplicity, we will go with the video game since the link has defined numbers for the village.
1. **Population is between 124 adults**: Based on the link (https://bulbapedia.bulbagarden.net/wiki/Jubilife_City), the population of the city is 87 in "Pokémon Diamond and Pearl" and 124 in "Pokemon Platinum". Therefore, let's assume a population of 124 to be safe. To be overly conservative, let's assume they are all adults (or have an electricity usage of full adults).
2. **100% efficient electricity production**: Assume when the statement says Voltorbs can "cleanly and efficiently produce electricity" that it is 100% efficient. Although, this seems impractical we can add a small correction factor at the end to compensate for any loss over lines/transmissions/etc.
3. **No other electric Pokemon can produce like Voltorbs**: Assume we have no Electrodes/Jolteons/Magnemites/etc., to supplement Voltorbs and this entire village is being powered by Voltorbs.
4. **Average villager consumes like a real human**: This needs to be explicitly stated as Ash Ketchum has not aged over 20 years so one could argue he consumes like a 10 year old or a 30 year old.
5. **Worst case scenario is 124 buildings (effective count: 248)**: In the video game, it seems like only 1 or 2 people are in a building at a time. Although an unsustainable and unrealistic way of living in a city, let us assume worst case and there are 124 buildings. To account for heavy electricity demand places like the Pokemon center or the Pokemart that may be open 24/7, lets multiply 124 by 2 to get an *effective* building count of 248 in the village. (Again, I realize the distribution of people in the game was skewed - some in Pokemon Gym, some on the outskirts of town).
6. **Residential power line has electric service of 10 amps (to model worst case)**: Residential power line typically has electrical service between 100 and 200 amps in the United States. Jubilife City is a large modern city in the southwestern part of Sinnoh - it should be safe to assume they have a similar amperage as the United States. But let us assume, it is the worst case and that they can only handle a minimum of 10 amps. Partly, because this will be a key factor in calculating required voltage and it is best to be conservative to estimate a safe amount of Voltorbs and partly because even though Voltorbs are 100% efficient, the transmissionns from the plant may not be.


**Basis**:
1. **Average household consumes 29.76 kWh/day**: Based on https://www.eia.gov/tools/faqs/faq.php?id=97&t=3, average US "U.S. residential utility customer" consumes 893 kWh/month.
2. **Thunderbolt results in 100,000 Volts**: Based on this article, thunderbolt, a classic move that a typical Voltorb learns can output 100,000 volts.


**Calculation Steps**:
1. If there are 248 effective buildings and based on the basis (1) above, each house/residential building, then the total electricity demand per day is 7382.13 kWh/day.
2. V * A = W; V * (10 amps) = (7382.13 kWh/day); V = 738,213 volts.
3. If you need 738,213 volts per day to run the city, you will need approximately 8 Voltorbs. Obviously, Pokemon are our friends and we cannot treat them like machines so we should have some backup Voltorb on standby in case a couple get sick or faint. Much like backup servers on the cloud, we should maybe prepare for 11-12 Voltorbs to power the city to be safe.

**Last Note/Sanity-Check**:
1. If the projected demand for the city is ~7,000 kWh/day. Then the monthly usage is approximately ~210,000 kWh/month. This means the city had energy needs almost as much as San Francisco (https://www.statista.com/statistics/807951/average-monthly-electricity-usage-in-major-us-cities/) in 2017.
2. Some assumptions like the number of buildings, and low amperage were purposefully taken to be a bit extra to compensate for the non-quantifiable areas of loss (e.g. energy transmission loss, energy consumption by Pokemon, etc.)
