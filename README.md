# Conta Bancária
Projeto feito para a disciplia de Linguagem de Programação II, ministrada pelo Professor André Solino, no Instituto Metrópole Digital, na Universidade Federal do Rio Grande do Norte.

# What is it?
Implementação em java de um Banco fictício.

O banco é formado pela classe ContaBancaria, que contém os seguintes atributos:

| Nome das variáveis | Tipo das variáveis |  
|--------------------|--------------------|
| nomeTitular        |       String       |
| CPFTitular         |       String       |
| dataCadastro       |  DateTimeFormatter |
| dataEncerramento   |  DateTimeFormatter |
| ativa              |       boolean      |

Na classe ContaBancaria há métodos abstratos ``criarConta()`` e ``encerrarConta()``.  Onde terá a passagem de parâmetros nome e cpf.

Há outros métodos abstratos como ``mostrarDados()`` que recebe o nome do titular, CPF, a data de cadastro e data de encerramento (só será mostrada se o atributo _ativa_ tiver o valor falso). Como, também, a variável "ativa" que retorna "Conta ativa" se o atributo tive o valor verdadeiro e “Conta desativada” caso contrário dataEncerramento

Na classe Banco (que possui um ArrayList de ContaBancaria) há os métodos ``procurarContaPorTitular()`` e ``procurarContaPorCPF()``, cujo nomes são auto explicativos.

Além disso tudo, há os mecanismos para ordenar as coleções de conta. Que são esses:

  - Ordenar pelo atributo nomeTitular;
  - Ordenar pelo atributo CPF;
  - Ordenar pelo nomeTitular e se forem iguais pelo CPF;
  - Ordenar pelo status da conta. Primeiro deve ser apresentado as contas ativas e depois as inativas;
  - Ordenar pelo atributo nomeTitular, e se tive mais de uma conta, pelo status, devendo ser apresentado as contas ativas primeiro;
  - Ordenar pelo atributo CPFTitular, e se tive mais de uma conta, pelo status, devendo ser apresentado as contas ativas primeiro.
  
## Colaboradores
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/marcosdelgado0408">
        <img src="https://avatars0.githubusercontent.com/u/44793167?s=400&v=4" width="100px;" alt="Marcos Delgado"/>
        <br />
        <sub><b>Marcos Delgado</b></sub>
      </a><br />
      <a href="https://github.com/nataly-enne/conta-bancaria/commits?author=marcosdelgado0408" title="Code">💻</a>
    </td>
    <td align="center">
      <a href="https://github.com/nataly-enne">
        <img src="https://avatars3.githubusercontent.com/u/26802307?s=400&v=4" width="100px;" alt="Nátaly Enne"/>
        <br />
        <sub><b>Nátaly Enne</b></sub>
      </a><br />
      <a href="https://github.com/nataly-enne/conta-bancaria/commits?author=nataly-enne" title="Code">💻</a>
    </td>
    <td align="center">
      <a href="https://github.com/HiltonThallyson">
        <img src="https://avatars1.githubusercontent.com/u/20178068?s=400&v=4" width="100px;" alt="Hilton Thallyson"/>
        <br />
        <sub><b>Hilton Thallyson</b></sub>
      </a><br />
      <a href="https://github.com/nataly-enne/conta-bancaria/commits?author=HiltonThallyson" title="Code">💻</a>
    </td>
  </tr>
</table>

