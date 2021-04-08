# MorpionCore

<b>Morpion Game Core</b> - challenge client IA This project has created for learn to code for dev student.

## What it is ?

This application is the simple core morpion game.

## How to play ?

For play, each student must to coding client player. The client player must take the map via main parameters and return
playing position.

- The return of core is json
- This json contain the actual map of game
- Example of map where player one named 1 and player two named 2. The pawn <b> - </b> is the empty place.

     1  -  2
  
     2  -  - 
  
     1  1  -

- Example of return json by the core game:

> [["1","-","2"],["2","-","-"],["1","1","-"]]

- Each position of map have a number, that the player may return for play

    *** *** ***
    * 1  2  3 *
    * 4  5  6 *
    * 7  8  9 *
    *** *** ***

### Game Rules

For a win, you have 04 combinaisons,
> ONE
>
>       *** *** ***
>       * 1  -  - *
>       * -  1  - *
>       * -  -  1 *
>       *** *** ***

> TWO
>
>       *** *** ***
>       * -  -  - *
>       * 1  1  1 *
>       * -  -  - *
>       *** *** ***

> THREE
>
>       *** *** ***
>       * -  -  1 *
>       * -  1  - *
>       * 1  -  - *
>       *** *** ***


> FOURTH
>
>       *** *** ***
>       * -  1  - *
>       * -  1  - *
>       * -  1  - *
>       *** *** ***

## How to use it ?

In this version, the core launch the scala client player; Why ? because my students coding in scala language.

You can modify this code easily.

### Launch

> java -jar name_of_core.jar name_of_client_one name_of_client_two

### Client Player

the core send in parameters, the actual map of game in json. the client must return the playing position in json.

## Contributing

My bad english ;)

#### Hotep!