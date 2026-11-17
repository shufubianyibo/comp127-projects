# Project: Character Creator
-------------------------------
### Team: Han, Shelly, Sabrina 
#### *Decorate a cute character with accessories and save your character!*


How to run: 
- Navigate to src/CharacterCreator.java and hit run
- Requires Java 17/21

features:
- Add decorations to your character and drag them into place! Change your blob color!
- Click on a decoration to edit it. make decorations bigger or smaller! Get creative!
  - click Done to save the decoration's location! Click Undo to revert the decoration to the last saved location!
- When you're done, hit Save Picture and it will save a png in your tmp folder! 

credits: 
- Han's custom-made pixel art!!
- Thanks to Paul for getting our Save Picture function working, even if by a slightly hacky method!
- brightness formula sourced from https://stackoverflow.com/a/596243 CC BY-SA 4.0
- referenced lots of Comp 127 class HW & activities (particularly painter & image transform arrays)

known issues: 
- images have bigger "selectable area' than they should due to transparent pixels, user may unwittingly select wrong decoration if there are overlapping decorations. otherise you can drag it anywhere!
- Color overlay is a bit funky, users should try to stick to a middle range of vales. extreme values make the blob look a little sad
- Buttons will stay visible once you call them, the ui layer briefly disappears for the purposes of saving picture
- code & classes are a bit messy in general; not much time to refactor! may have redundancies / unused code


societal impact statement:
We set out to create a fun and simple project with  entertainment value, but we recognize that there are also accessibility/inclusivity considerations that we should be aware of. 
- Our game isn’t very accessible to users with disabilities which affect their sight & movement. we use mouse-based interactions, which makes it tough for those with limited dexterity / those reliant on screen readers, keyboard navigation, or assistive devices to use the interface. the movement needed to click on small buttons and place things precisely requires fine motor control. in the future, including keyboard inputs or alternative input methods would be a good way to address ths need.
- we have a character designs and decoration choices that reflect our team's own sense of aesthetics, but our limited set of options may not be inclusive of diverse identities or cultural preferences. e.g, we include a santa hat, but we don't necessarily have decor from other holidays or celebrations. The items mostly aim to be appealing to mainstream users due to limitations in project scope, but that doesn't always have to be the case. In a larger project, it would be great to have more diverse cultural perspectives and identities included and thought about. Representation in media matters no matter what form it takes, but it is  especially important when we are thinking about things meant to be customizable for everyone.


