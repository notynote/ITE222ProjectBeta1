# ITE222ProjectBeta1 - Project for Programming 2 class at Stamford University

Project Game (Turn base fighting game)
  -	Working Stage
    o	Create Character Function (Done)
      	Class Select (in case user use class select mode)
        •	Warrior
        •	Archer
        •	Mage
    o	Attack Method (Done)
    o	Battle Stage (Player Versus Player)[done]
      	Random which player start first[done]
      	First player select attack[done]
      	Second select defend[done]
      	Calculate final damage then reduce second player hp[done]
      	Reverse the role then repeat until one die[done]
      	Winner screen[done]

  -	Components
    o	Game mode
      	Arcade Mode [done]
        •	10 stage vs CPU
      	Quick Match VS CPU [done]
        •	Random CPU to fight
      	Player VS Player[done]
    o	Character
      	Name [done]
      	Status (Random) Min 1 Max 9 [done]
        •	STR
        •	WIS
        •	DEX
        •	HP (100-500)
      	Class (Random) [done]
        •	Warrior
        •	Mage
        •	Archer
      	Skill [done]
        •	Close
          o	Offend – Stab
          o	Defend – Shield Block
        •	Magic
          o	Offend – Fire
          o	Defend – Ice Wall
        •	Range
          o	Offend – Shoot
          o	Defend – Dodge
        • Normal
          o	Offend – Normal Attack
          o	Defend – Normal Defend
       Attribute Amplifier[done]
        •	Close 2x Dmg Magic
        •	Magic 2x Dmg Range
        •	Range 2x Dmg Close
        •	Close 0.5x Dmg Range
        •	Range 0.5x Dmg Magic
        •	Magic 0.5x Dmg Close
        •	Normal 1x Dmg All
        •	Normal 2x Normal
      	Attack Damage [done]
        •	Random according to Status
          o	Status 1-3
       Dmg 10-30
          o	Status 4-6
      	Dmg 40-60
        o	Status 7-9
      	Dmg 70 – 100
        •	Normal Attack
          o	All Status
      	3-9
        •	Dmg 10-30
          	10-18
        •	Dmg 40-60
          	19-27
        •	Dmg 70-100
    -	Workflow
      o	Create Character
      o	Generate status
      o	When start fight random the starter
      o	Everytime to attack attacker choose attack type
        	Attack type
          •	Class type
          •	Normal type
      o	Defender choose defend type
        	Defend type
          •	Class type
          •	Normal type
      o	Send Skill name + status to calculate damage
      o	Get damage then calculate the Attribute Amplifier to get the final damage to apply to defender
      o	Change turn
      o	Repeat until one of player dead

  -	Possible Improvement
      o	Weapon or Item that enchant status
        	Maybe if battle excess 5 turn then random weapon appear
      o	CPU Difficulty
        	Easy
        	Normal
        	Hard
        	Nightmare
      o	Network connection for player versus player
      o	Cheat code to enable access to god class[done]
      o	Character creation with save and load feature
        	Save file as text that player can load later
      o	Convert “character class” to abstract class
        	Create new extended class
          •	Warrior
          •	Mage
          •	Archer
        	Use abstract to define each class skill
        	Clean up code in Battle to use Abstract code[done]
      o	Implement Thread.sleep(1000); to delay text[done]
      o	Chance to dodge during battle

  -	Version History and Changelog
    o	Idea (Alpha)
      	Added Game mode
        •	Arcade (10 Stage vs CPU)
        •	Quick match (Random 1 of 10 CPU)
        •	Player VS Player
    o	Normal Mode (Choose Attack + Defend skill)
    o	Attack only mode (Choose Attack Only)
    o	Auto mode (Random both attack and defend skill)
      	Added character creator
        •	Test the character random system
        •	Character cannot be save
      	Character
        •	Archer
        •	Warrior
        •	Mage
        •	Secret

    o	Beta 1
      	Plan
        •	Use more interface
        •	Try to reduce hp check from multiple time into 1 time
        •	Save player in database
        •	Convert skill into object
        •	Chance to dodge during battle
      	Change [doing]
      	Changed [done]
        •	Change String checker to Try and Catch
        •	Clean some code in battle
        •	Make Helper Class to contain frequency use method
        •	Add delay between each message
        •	Allow user to choose the range of cpu difficulty in quick play mode
