# Processamento assíncrono e paralelo

## Objetivos
1. Entender o conceito de síncrono e assíncrono.
2. Entender o funcionamento da API de Threads do java.
3. Entender o Funcionamento do PararelStream do java.

### Thread
É um pequeno programa que trabalha como um subsistema, sendo uma forma de um processo dividir-se em duas ou mais tarefas.
 Essas tarefas múltiplas podem ser executadas simultaneamente para rodar mais rápido do que um programa num único bloco 
ou praticamente junta.

### Processamento síncrono e assíncrono
O Processamento síncrono, são todos os processamentos que ocorrem em sequência (sincronia).
Os processos são executados em fila.É preciso que um processo termine para que outro processo seja executado. 

### Issues
#### java.util.ConcorretModificationException
##### Descrição
Esse erro ocorre quando há tentativa de alterar o estado de uma thread enquanto a mesma esta em execução.
##### Possíveis motivos 
Guardar um lista de threads dentro de um java.util.List, java.util.Set. Pois esses arrays não são 'Thread Safe'.  
##### Solução
Ao invés de usar List ou Set. Utilizar CopyOnWriteArrayList || CopyOnWriteArraySet, ambas da biblioteca java.util.cocurrent.
 