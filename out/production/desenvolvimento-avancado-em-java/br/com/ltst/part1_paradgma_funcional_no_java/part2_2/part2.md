### Lambda do Java
Os lambdas obedecem ao conceito de paradigma funcional,
com eles podemos facilitar legibilidade do nosso código, além disso, com a nova API Functional do Java podemos ter uma 
alta produtividade para lidar com objetos.

Primeiramente, devemos entender o que são ‘interfaces’ funcionais.

#### Interfaces funcionais:
São ‘interfaces’ que possuem apenas um método abstrato. 
Geralmente as ‘interfaces’ funcionais possuem uma anotação em nivel de classe(@FunctionalIterface), para forçar 
o compilador a apontar um erro se a ‘interface’ não estiver de acordo com as regras de uma interface funcional.
Esta anotação não é obrigatória, pois o compilador consegue reconhecer uma interface em tempo de compilação.


Antes do java 8, se quiséssemos implementar um comportamento específico para uma única classe deveríamos utilizar 
uma classe anonima para implementar este comportamento.

Agora que sabemos como se define uma interface funcional podemos, aprender como se define uma lambda.

Estrutura de uma lambda:

 ``` java
  InterfaceFuncional nomeVariavel = parametro -> logica;
  ```


IMPORTANT!!!
- Quando um lambda possui apenas uma instrução no corpo da sua lógica não é necessário o uso de chaves.
  
    Ex:
    ``` java
    Funcao colocarPrefixoSenhor = valor -> "Sr. " +valor;
    ```
  
- Se a função possuir mais de uma instrução DEVEMOS utilizar chaves e explicitar o retorno, caso o retorno for diferente de void.

    Ex:
    ``` java
    Funcao colocarPrefixoSenhor = valor -> {
        String valorComPrefixo = "Sr. " +valor;
        String valorComPrefixoFinal = valorComPrefixo+".";
        return valorComPrefixoFinal;
    };
    ```

#### TAIL CALL 
Recursão em cauda é uma recursão onde não há nenhuma linha de código após a chamada do próprio método e, sendo assim,
não há nenhum processamento a ser feito após a chamada recursiva.

OBS: A JVM não suporta a recursão em cauda, ele lança um estouro(stackOverFlow)

#### MEMOIZATION
É uma técnica de otimização que consiste no cache do resultado de uma função, baseado nos parâmetros de entrada.
COm isso, nas seguintes execuções conseguimos ter uma resposta mais rápida.