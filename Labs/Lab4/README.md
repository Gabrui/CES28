# REQUISITOS

## Todos os requisitos foram cumpridos:

OBS: Considerei o usuario-programador como cliente do package e não só cliente da classe, para que métodos e construtores protected não fossem acessados de forma indevida, satisfazendo os requisitos.

1. *NF não pode ter zero IV. Deve ter 1 ou mais*: Isso foi implementado com o Builder, que não aceita construir uma NF com zero IV. Para garantir a sua construção correta, a NF tem seu construtor protected e também verifica isso.

2. *Todo IV deve pertencer a exatamente uma NF*: Os IVs são criados pelo Builder e Clonados para cada nova NF criada pelo builder. Assim, não há como existirem IVs em mais de uma NF ou órfãos. A NF também cria (clonando) seus próprios IV (composição).

3. *Todo IV se referirá a exatamente um produto ou serviço*: No momento de sua criação, o IV terá uma referência para o produto ou serviço, que ele vai buscar no BD, através de uma String. Se ele não conseguir encontrar o P/S ele gera exceção.

4. *Um P/S deve sempre pertencer a um IV ou a um outro P/S*: Não é possível cria P/S, apenas BD pode fazê-lo. Apenas IVs e P/S compostos (além do BD) conhecem P/S.

5. **Só podem ser adicionados à uma NF, P/Ss que estejam cadastrados no BD**: Apenas o BD pode criar PS, cuja construção é protegida (Package Protected).

6. **Uma NF é criada no estado “em elaboração”. NF deve ser validada pelo BD, completamente imutável:** O padrão builder resolve esse problema, já que as notas fiscais são imutáveis, e fez-se uma extensão do Builder da nota fiscal para um Builder de Nota fiscal validada pelo BD. A criação de NF é protegida e feita pelos buiders.

7. *Cada NF validada deve ter um identificador único gerado pelo BD*: Durante a sua validadacao, o BD gera um int sequencial para a NF.

8. *Há um conjunto de varios impostos a serem aplicados em uma NF, armazenados previamente em um BD*: O BD tem seus impostos e cada imposto sabe se calcular de acordo com o PS. 

9. *Deve ser fácil para o usuário-programador incluir um novo imposto*: Os impostos utiliziam um padrão visitor recursivo, executado em pré-ordem. Assim, se quiserem, podem calcular de acordo com a posição dos PS na árvore de PS (percorrida em pré-ordem).

10. *Inclusive um imposto pode depender da sequência de IVs e/ou P/S*: Como descrito no item 9, a árvore é percorrida em pré-ordem e o imposto pode utilizar essa ordem para se calcular.

11. ~~BD:Cliente~~

12. *Deve ser facil de estender o sistema para especificar novas categorias de  produtos e serviços*: Todos os PS se baseiam em uma classe abstrata e a criação de novos tipos de produtos e categorias se dá pela instanciação das classes concretas Produto, Servico ou ProdutoServicoComposto.

13. *NF (antes da validação) pode ter os seus itens de venda devem ser modificados, adicionados ou deletados*: Isso acontece por meio do seu Builder, e não da NF em si, que é imutável. Os métodos de acesso à NF e ao Builder são seguros, sendo ou criada cópias às referências de objetos, ou protegidos ou ainda são retornados valores primitivos.

14. *Código de BD (mesmo que mockado), deve estar completamente separado, desacoplado do restante do sistema em package separado* Todo comportamento de BD é encapsulado pela interface (Facade) de BD, e há apenas uma instância desse objeto (Singleton).

15. *Código de calculo de impostos devem estar separados e desacoplados  de forma a poderem ser modificados sem afetar o resto do sistema*: Utiliza-se uma interface de imposto e a sua implementação é desacoplada, apenas o imposto sabe se resolver.

16. *Todas as entidades armazenados em BD devem corresponder a entidades imutáveis uma vez retirados do BD*: Todos os objetos retornados de BD são imutáveis (não há setters, apenas getters de valores primitivos) e têm a sua criação protegida (Package Protected).

17. **Cada produto ou serviço (P/S) pode ser subdividido em outros produtos e/ou serviços**: Há a classe ProdutoServicoComposto, que comtém ProdutosServico (Composite), ele sabe calcular e passar imposto pela árvores, de tamanho ilimitado.

18. **Cada imposto deve percorrer toda a hierarquia de subdivisões de um P/S**: Utiliza-se a pré-ordem para isso, o pai chama o cálculo do imposto dos seus filhos e só depois chama o seu próprio cálculo do imposto, é um visitor-composite.

19. *O cálculo de um imposto pode depender não apenas dos IV e P/S de uma nota fiscal, mas também do conjunto e valores de NFs anteriores ao longo do tempo*: Há o padrão de DataObject, no qual o BD armazena e atualiza um objeto com dados específicos a um imposto. No caso mais simples, esse dado é só um inteiro (que já é comtemplado na interface do imposto em getRealimentacao() e setRealimentacao()). Em um caso mais complexo, esse seria um objeto com multiplos atributos que seria armazenado no BD e repassado ao imposto por meio do setRealimentacao, e depois do seu cálculo, atualizado por meio do getRealimentacao.

20. *Suponha que a NF pode ter outras partes além de lista de IV e estado/ID, mesmo que nesse trabalho basta preencher um atributo “outros”*: Basta extender a NF e os seus respectivos builders, adicionando os atributos necessários, uma vez que se utilizou o padrão criacional Builder. Assim, bastaria extender o construtor da nota fiscal para que ele utilizasse novos getters do novo Builder.

21. *Deve permitir imprimir explicitamente a NF, com ID, IVs e PS*: A impressão é realizada pelo método imprimir() da NF, que retorna uma String, para que o código possa ser testado automaticamente.






