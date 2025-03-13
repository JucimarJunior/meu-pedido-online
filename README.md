# Aplicativo Para Listagem e Criação de Pedidos

Este projeto é um aplicativo para a criação e listagem de pedidos utilizando uma API feita em .Net Core 9.



## Descrição

- Aplicativo android nativo
- 100% feito em Java
- Arquitetura MVVM
- Retrofit para requisições HTTP
- Código Limpo
- Navigation Component


## Como utilizar a aplicação?

Basta fazer o clone do projeto na branch master. Após ter feito o download do projeto, no arquivo/classe RetrofitConfig que está na pasta service, na linha 12: 

`private static final String BASE_URL = "http://10.0.2.2:porta";`

no lugar de "porta" substituir pela porta gerada ao executar o backend local do projeto: https://github.com/JucimarJunior/api-order-backend


## Como utilizar o Backend para realizar as requisições?

Você precisa fazer o download do projeto com a API neste link: https://github.com/JucimarJunior/api-order-backend. A API possui os métodos HTTP GET e POST. Os dados no formato são esses:

```json
{
  "name": "string",
  "product": "string",
  "quantity": 0,
  "total": 0
}


## Dicas Finais

Todas as instruções de como utilizar a API em .NET Core 9 estão no readme do projeto: https://github.com/JucimarJunior/api-order-backend
