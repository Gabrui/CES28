# REQUISITOS:

	1 NF não pode ter zero IV. Deve ter 1 ou mais:
	Isso foi implementado com o Builder, que não aceita construir uma NF com zero IV.

	2 Todo IV deve pertencer a exatamente uma NF:
	Os IVs são criados pelo Builder e Clonados para cada nova NF criada pelo builder.
	Assim, não há como existirem IVs em mais de uma NF ou órfãos.