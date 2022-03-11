# TotalWarBattleResolver
A Java / SpringBoot project which was inspired by the Auto Resolve feature from the original Rome Total War

Thanks for checking out this project! As you can see by the commits I wrote this in about an hour, as a speedrun idea.

What does this project do? It:
1) Resolves battles like the auto-resolver from Rome Total War
2) Takes in a bunch of data regarding the attacking armies, factions, leaders, units etc
3) Spits out a result indicating how heroic was the victory and how many people died.
4) Crunches numbers in a kind of interesting way, by summing up a unit's contribution to the battle and multiplying it by any equipment or experience modifiers like from the original game.

How can I run this code?:
1) Clone the project
2) Download postman
3) All of the endpoints you need are in the "TestController" class
4) I've provided a sample JSON but you can obviously construct your own too

How can I contribute:
1) Open an issue, fork, make a PR, message me, anything you like!

Some nice features for the future if I ever get time:
1) Actually tally casualty counts
2) Calculate if generals have died in a battle
3) Calculate offense and defense separately instead of lumping them together
4) Sieges, fort battles
5) Unit special abilities? Not sure if the auto-resolver actually handles this
6) I'm assuming an integer overflow happens somewhere with large counts/amounts of units

Thanks again!! Enjoy! Please do write if you like it.
