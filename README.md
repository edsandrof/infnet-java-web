Infnet - Banco de Dados e Persistência em Java - Prof. Fabio Araujo Guilherme

Utilizando o Spring Framework, desenvolva um projeto que atue no mapeamento de uma aplicação web. Escolha um tema e defina as entidades necessárias para representá-las.

Organize as regras de negócio em seis classes da seguinte maneira:

- Uma classe mãe abstrata
  - Três classes filhas
- Uma classe concreta sem mãe
- Uma classe principal que tenha dois relacionamentos:
  - 1:1 com a classe concreta
  - 1:n com a classe mãe


Esta aplicação deve ter as seguintes especificidades:

- Banco de dados criado automaticamente no start da aplicação.
- Configurações de criação e de acesso aos dados em arquivo de propriedade.
- Adição das dependências necessárias para a utilização do Spring Data.
- Adição das dependências necessárias para o hibernate/jpa.
- Os atributos e os relacionamentos das classes de negócio devem ser mapeados.
- O projeto precisa estar organizado em três camadas (podem, opcionalmente, incluir uma camada de visão caso caso queiram):
  - controle; serviço; e repository.

- Todas as classes precisam ter as seguintes funcionalidades:
  - incluir;
  excluir;
  alterar;
  obter lista; e
  obter por id.

- Classes loaders precisam ser criadas para incluir informações iniciais no banco.