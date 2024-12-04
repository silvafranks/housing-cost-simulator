# housing-cost-simulator

## Descrição do Projeto
Este sistema foi desenvolvido para ajudar consumidores a economizarem ao realizar compras em diferentes bairros. Ele permite comparar preços de produtos entre bairros e identificar quais são mais econômicos, tanto para itens específicos quanto para o custo geral. Além disso, o sistema fornece insights sobre o histórico de preços, destacando bairros que frequentemente possuem os menores preços ao longo do tempo.

Funcionalidades
- Comparação de Preços: Identifique o bairro com o menor preço para produtos específicos ou para o total de uma lista de compras.
- Histórico de Preços: Analise quais bairros apresentaram os menores e maiores preços ao longo de meses.
- Ultimos preços: Liste os ultimos preços de cada bairro.

![Diagrama de cebola(1)](https://github.com/user-attachments/assets/22747a19-56e0-40b8-b7fc-2228089fb933)

![C4 Architecture](https://github.com/user-attachments/assets/e5c81911-c3fb-416e-afb8-0a2478e20840)



importante criar os usuarios no mongodb:

db.createUser({
user: "root",
pwd: "root",
roles: [{ role: "root", db: "admin" }]
})
