[![Build Status](https://travis-ci.org/dnltsk/bowling.svg?branch=master)](https://travis-ci.org/dnltsk/bowling)
[![codebeat badge](https://codebeat.co/badges/f928216c-19a3-4ce0-8c0d-5a334b16666b)](https://codebeat.co/projects/github-com-dnltsk-bowling-master)
[![codecov](https://codecov.io/gh/dnltsk/bowling/branch/master/graph/badge.svg)](https://codecov.io/gh/dnltsk/bowling)

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

`java -jar build/libs/bowling-*.jar samples/game.txt`