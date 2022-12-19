## Hero & Legends
---------------------------------------------------------------------------
![image](https://github.com/ZhengxuWangAndy/HeroLegend_Game/blob/main/imgs/Screen%20Shot%202022-12-19%20at%2012.40.37%20AM.png)
![image](https://github.com/ZhengxuWangAndy/HeroLegend_Game/blob/main/imgs/Screen%20Shot%202022-12-19%20at%2012.40.00%20AM.png)
## Files
---------------------------------------------------------------------------
<A brief description of each file and what it does>

Classes below:

1. `ood.Hero.java` ->  The ood.Hero class defined the common things of heroes.
   
2. `ood.Exoskeletons.java` ->  the class for ood.Exoskeletons to process its own specialty, extends from ood.Monster
   
3. `ood.Equipment.java` ->  the class for Equipments to process its own methods and attributes, extends from ood.Itemstems
   
4. `ood.HerosTeam.java` ->  the class for Heroes team, extends from the general team class.
   
5. `ood.Spells.java` -> * The general abstract class of ood.Items.Spells, extends from consumable items.
   
6. `ood.Items.IceSpell.java` ->  Use for new a Ice spell item with it's own category. Extends from ood.Spells.
   
7. `ood.Items.Potions.java` ->  The class of ood.Potions, extends from consumable items, use for produce these kinds of potions.
   
8. `ood.Team.java` ->  the general class for team, using the generic type to build the role's map.
   
9. `ood.Dragons.java` -> * the class for dragons to process its own specialty, extends from ood.Monster
   
10. `ood.Inventory.java` -> * for contains items, using to build market and hero's backpack.
   
11. `ood.ItemGetter.java` ->  the class for getting different kinds of items from the txt file.
   
12. `ood.Sorcerers.java` ->  The ood.Sorcerers class defined the attributes and methods of ood.Sorcerers extends from ood.Hero.
   
13. `ood.Utils.FileReader.java` -> * The File reader to handle different file in to a file object.
   
14. `ood.Battle.java` ->  the class for battle, using generics type to deal with different kind of hero and monsters
   
15. `ood.Market.java` -> * The class for building a market contains a ood.Inventory.
   
16. `ood.Paladins.java` -> * The class for build a ood.Paladins hero, extends from ood.Hero, contains its own specialty.
   
17. `ood.GameMap.java` -> * The game's map extends from ood.Board and contains cell.
   
18. `ood.InputCheck.java` ->  the class for input check, check is it a valid number or string, and it's range.
   
19. `ood.Spirits.java` ->  The class for build a ood.Spirits ood.Monster, extends from ood.Monster, contains its own specialty.
   
20. `ood.Consumable.java` ->  the class for ood.Consumable items, extend from ood.Itemstems
   
21. `ood.Controller.java` ->  the class for deal with the input when user want's to move on map.
   
22. `ood.Processor.java` -> * Process the whole game's process.
   
23. `ood.HeroLegendCell.java` ->  the class for this game's special ood.Cell, contains  extends from the general cell class.
   
24. `ood.Main.java` ->  Game start
   
25. `ood.Board.java` ->  the class for ood.Board, reuse the board class from the board game
   
26. `ood.RoleMethods` -> Interface for define the common method and necessary method of Roles.
   
27. `ood.Items.ood.Items.java` -> * the abstract class of items, include the common things of all items.
   
28. `ood.MonsterTeam.java` ->  the class for ood.Monster team, extends from the general team class.
   
29. `ood.Monster.java` ->  The ood.Monster class defined the common things of monsters.
   
30. `ood.Items.FireSpell.java` -> * Use for new a Fire spell item with it's own category. Extends from ood.Spells.
   
31. `ood.Role.java` -> * The ood.Role class defined the common things of heroes and monsters.
   
32. `ood.Items.LightningSpell.java` ->  Use for new a Lightning spell item with it's own category. Extends from ood.Items.Spells.
   
33. `ood.Cell.java` ->  the class for ood.Cell, reuse the ood.Cell class from the board game, it's a general cell class.
   
34. `ood.ColorfulOutput.java` ->  the class for deal with the output, giving colorful output.
   
35. `ood.Armor.java` -> * the class for armory, extends from ood.Items.Equipment
   
36. `ood.Warriors.java` ->  The ood.Warriors class defined the attributes and methods of ood.Warriors extends from ood.Hero.
   
37. `ood.Items.Weapon.java` ->  the class for ood.Weapon, extends from ood.Items.Equipment

38. `ood.ItemMethods` ->  Interface for all items.



## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in ConfigFiles, for parser class to
read class>

All the initial data of monsters, heroes and items stores in /data/txt_files


2. Notes

Using the factory design pattern

Auto-compute hand value.

Non-stop playing.

Different color for outputs.

Clearly prompt.

Can exit anytime.

Can robustly process any possible wrong input.(including give String to number, wrong format and etc.) 

Highly completed.

Guarantee every player have different name.

Easily change initial money in config.


## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "pa1" after unzipping the files
2. Run the following instructions:
<Example below>
   javac -Xlint:unchecked -d bin ood/Main.java  

   java -cp bin ood.Main
