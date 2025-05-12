%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void yyerror(const char *s);
int yylex();

typedef struct {
    char* str;
    int num;
    char* id;
} YYSTYPE;

#define YYSTYPE_IS_DECLARED 1
%}

%union {
    char* str;
    int num;
    char* id;
}

%token <str> STRING
%token <id> IDENTIFIER
%token <num> NUMBER
%token WHEN IN AFTER BEFORE
%token COLON COMMA LBRACE RBRACE

%%

program:
    | program statement
    ;

statement:
      rule
    | action_statement
    ;

rule:
    WHEN condition LBRACE action_block RBRACE
    ;

condition:
    event
    | event time_condition
    ;

event:
    IDENTIFIER IN STRING
    ;

time_condition:
      AFTER time
    | BEFORE time
    ;

time:
    NUMBER COLON NUMBER
    ;

action_block:
    | action_block action_statement
    ;

action_statement:
    IDENTIFIER arguments
    ;

arguments:
    argument
    | arguments COMMA argument
    ;

argument:
      STRING
    | IDENTIFIER
    ;

%%

void yyerror(const char *s) {
    fprintf(stderr, "Erro de sintaxe: %s\n", s);
}
