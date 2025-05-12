#include <stdio.h>

int yyparse(void);

int main(int argc, char** argv) {
    if (argc > 1) {
        FILE* file = fopen(argv[1], "r");
        if (!file) {
            perror("Erro ao abrir arquivo");
            return 1;
        }
        extern FILE* yyin;
        yyin = file;
    }

    printf("Iniciando interpretação do script HOMS...\n");
    int result = yyparse();

    if (result == 0) {
        printf("Parsing concluído com sucesso.\n");
    } else {
        printf("Falha no parsing.\n");
    }

    return result;
}
