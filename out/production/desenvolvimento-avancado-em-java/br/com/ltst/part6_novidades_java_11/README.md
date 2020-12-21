# Novidades do Java 11

- Cliente httpclient;
- O que mudaram nas APIs de mais relevante;
- Novo tipo de inferência — lambdas;

## Http Client API

Um dos recursos que foram incluídos na próxima versão do JDK 11 é a API do cliente HTTP padronizada que visa substituir
a classe HttpUrlConnection legada, que está presente no JDK desde os primeiros anos do Java. O problema com essa API
antiga é descrito na proposta de aprimoramento, principalmente porque agora ela é considerada antiga e difícil de usar.

A nova API suporta HTTP /1.1 e HTTP /2. A versão mais recente do protocolo HTTP foi projetada para melhorar o desempenho
geral do envio de solicitação por um cliente e do recebimento de respostas do servidor. Isso é conseguido através da
introdução de várias alterações, como multiplexação de fluxo, compactação de cabeçalho e Push Promise. Além disso, novo
cliente Http também suporta de forma nativa webSockets.
