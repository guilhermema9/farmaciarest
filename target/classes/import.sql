-- Criando os Medicamentos
INSERT INTO medicamento (id, fabricante, nome, preco) VALUES (1, 'EMS', 'Paracetamol', 4.99);
INSERT INTO medicamento (id, fabricante, nome, preco) VALUES (2, 'Sanofi', 'Dipirona', 3.49);
INSERT INTO medicamento (id, fabricante, nome, preco) VALUES (3, 'Bayer', 'Amoxicilina', 19.99);

-- Criando os Pedidos
INSERT INTO pedido (id, cliente_nome, cliente_cpf) VALUES (1, 'João Silva', '123.456.789-00');
INSERT INTO pedido (id, cliente_nome, cliente_cpf) VALUES (2, 'Maria Oliveira', '987.654.321-00');
INSERT INTO pedido (id, cliente_nome, cliente_cpf) VALUES (3, 'Carlos Souza', '111.222.333-44');

-- Criando os ItensPedido associados aos Pedidos e Medicamentos
-- Pedido 1, Medicamento 1 (Paracetamol), Quantidade 2
INSERT INTO item_pedido (id, pedido_id, medicamento_id, quantidade) VALUES (1, 1, 1, 2);
-- Pedido 1, Medicamento 2 (Dipirona), Quantidade 1
INSERT INTO item_pedido (id, pedido_id, medicamento_id, quantidade) VALUES (2, 1, 2, 1);
-- Pedido 2, Medicamento 3 (Amoxicilina), Quantidade 3
INSERT INTO item_pedido (id, pedido_id, medicamento_id, quantidade) VALUES (3, 2, 3, 3);
-- Pedido 3, Medicamento 1 (Paracetamol), Quantidade 1
INSERT INTO item_pedido (id, pedido_id, medicamento_id, quantidade) VALUES (4, 3, 1, 1);
-- Pedido 3, Medicamento 3 (Amoxicilina), Quantidade 2;
INSERT INTO item_pedido (id, pedido_id, medicamento_id, quantidade) VALUES (5, 3, 3, 2);

