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

Observação importante: Caso os testes sejam feitos em um emulador do android, ao utilizar a api-order-backend em .NET, por causa de algumas limitações do android específicas para o emulador, é necessário colocar na `BASE_URL` o IP do mesmo ao invés do localhost diretamente, como no exemplo: `"http://10.0.2.2:5182"`, para que os testes sejam bem sucedidos. Mais orientações no link da própria documentação do android:
<a href=“http://exemplo.com/](https://developer.android.com/studio/run/emulator-networking?hl=pt-br“>Configurar a rede do Android Emulator</a>

   
## Como utilizar o Backend para realizar as requisições?

Todas as orientações de como executar a API, estão no projeto neste link: https://github.com/JucimarJunior/api-order-backend. Você precisa fazer o download do projeto com a API. A API possui os métodos HTTP GET e POST. Os dados no formato JSON são esses:

```json
{
  "name": "string",
  "product": "string",
  "quantity": 0,
  "total": 0
}
```

## Demonstração

https://github.com/user-attachments/assets/eb7f9ccf-2bc8-4471-98a5-a09e1dafa037
