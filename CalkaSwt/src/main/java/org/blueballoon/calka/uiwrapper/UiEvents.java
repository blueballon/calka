package org.blueballoon.calka.uiwrapper;

// enums to decouple framework-specific(swt,swing,..) ui events from calculator logic
// for each event, an enum is required
public enum UiEvents
{
    DIGIT_0,
    DIGIT_1,
    DIGIT_2,
    DIGIT_3,
    DIGIT_4,
    DIGIT_5,
    DIGIT_6,
    DIGIT_7,
    DIGIT_8,
    DIGIT_9,
    DIGIT_COMMA,
    MODIFIER_CHANGESIGN,
    OPERATION_PLUS,
    OPERATION_MINUS,
    OPERATION_MULTIPLY,
    OPERATION_DIVIDE,
    STACK_ENTER,
    STACK_SWAP,
    STACK_DROP,
    STACK_CLEAR
}
