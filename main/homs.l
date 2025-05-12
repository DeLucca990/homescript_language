%{
#include "homs.tab.h"
#include <string.h>
%}

%%
"when"              { return WHEN; }
"in"                { return IN; }
"after"             { return AFTER; }
"before"            { return BEFORE; }

\"[^\"]*\"          { yylval.str = strdup(yytext); return STRING; }

":"                 { return COLON; }
","                 { return COMMA; }
"{"                 { return LBRACE; }
"}"                 { return RBRACE; }

[0-9]+              { yylval.num = atoi(yytext); return NUMBER; }

[a-zA-Z_][a-zA-Z0-9_]* { yylval.id = strdup(yytext); return IDENTIFIER; }

[ \t\r\n]+          ; // ignora espaços e quebras de linha
.                   { printf("Caractere inesperado: %s\n", yytext); return yytext[0]; }
%%

int yywrap(void) {
    return 1;
}
