# Conta Bancária
Projeto feito para a disciplia de Linguagem de Programação II, ministrada pelo Professor André Solino, no Instituto Metrópole Digital, na Universidade Federal do Rio Grande do Norte.

# What is it?
Implementação em java de um Banco fictício.

O banco é formado pela classe ContaBancaria, que contém os seguintes atributos:

| Nome das variáveis | Tipo das variáveis |  
|--------------------|--------------------|
| nomeTitular        |       string       |
| CPFTitular         |       string       |
| dataCadastro       |  DateTimeFormatter |
| dataEncerramento   |  DateTimeFormatter |
| ativa              |       boolean      |

Na classe ContaBancaria há métodos abstratos ``criarConta()`` e ``encerrarConta()``.  Onde terá a passagem de parâmetros nome e cpf. 
