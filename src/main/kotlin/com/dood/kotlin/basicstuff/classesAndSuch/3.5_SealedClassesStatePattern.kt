package com.dood.kotlin.basicstuff.classesAndSuch

/**
 * https://medium.com/@spaghetticode/finite-state-machines-in-kotlin-part-1-57e68d54d93b
 * Great example of using sealed classes
 */
data class DFA(
    val states: Set<State>,
    val inputs: Set<Input>,
    val delta: (State, Input) -> State,
    val initialState: State,
    val isFinalState: (State) -> Boolean
)

data class State(val name: String)
data class Input(val value: String)

val a = Input("press")
val s0 = State("off")
val s1 = State("on")

val dfa = DFA(
    states = setOf(s0, s1),
    inputs = setOf(a),
    delta = { state: State, input: Input ->
        when (input) {
            a -> when (state) {
                s0 -> s1
                s1 -> s0
                else -> state
            }
            else -> state
        }
    },
    initialState = s0,
    isFinalState = { state: State -> state == s1 }
)