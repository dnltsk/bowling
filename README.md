[![Build Status](https://travis-ci.org/dnltsk/bowling.svg?branch=master)](https://travis-ci.org/dnltsk/bowling)

# bowling
~Bowling Game Kata

Calculates the total score from a given score card. Input data should be formatted like this:

```
14 45 6/ 5/ X 01 7/ 6/ X 2/6
```

* frames are separated with ` ` (space)
* spare ends with a `/`
* strike is just a `X`
* last frame can have an extra roll, sample notations of last frame are: `01`, `1/0`, `0/4`, `X5`, `XX`

## test

`./gradlew clean test`

## build

`./gradlew clean bootJar`

## execute

`java -jar build/libs/bowling-*.jar game.txt`