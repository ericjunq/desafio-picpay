# 💸 Desafio Backend - PicPay Simplificado

Este projeto foi desenvolvido como o meu **primeiro desafio prático de backend**, com o objetivo de aplicar conceitos fundamentais de desenvolvimento de APIs, regras de negócio e organização de código.

O desafio utilizado é um case bastante conhecido na comunidade, frequentemente encontrado em conteúdos no YouTube e fóruns de desenvolvimento, apesar de ser um desafio mais antigo.

---

## 📌 Sobre o desafio

As instruções utilizadas como base estão disponíveis no repositório oficial:

👉 [Repositório do desafio PicPay](https://github.com/PicPay/picpay-desafio-backend?utm_source=chatgpt.com)

Essas são consideradas as **instruções essenciais** do desafio, que propõem a construção de uma API de pagamentos simplificada.

Lembrando que trata-se de um desafio antigo e que não é funcional hoje em dia. O repositório que contem o desafio foi encontrado no youtube.

O objetivo principal é simular o funcionamento básico de uma plataforma de transferência de dinheiro entre usuários, inspirada no PicPay.

---

## 🎯 Objetivo

Desenvolver uma **API RESTful** que permita:

* Cadastro de usuários
* Transferência de dinheiro entre contas
* Validação de regras de negócio
* Garantia de consistência nas transações

Segundo o desafio, o sistema representa um **PicPay simplificado**, onde usuários possuem uma carteira com saldo e podem realizar transferências.

---

## 🧾 Regras de negócio

As principais regras propostas pelo desafio são:

* Existem dois tipos de usuários:

  * Usuários comuns
  * Lojistas

* Ambos possuem:

  * Nome completo
  * CPF/CNPJ
  * Email
  * Senha

* CPF/CNPJ e email devem ser únicos no sistema

* Usuários comuns podem:

  * Enviar dinheiro
  * Receber dinheiro

* Lojistas:

  * **Apenas recebem transferências (não enviam)**

* Antes de uma transferência:

  * Deve ser validado se o usuário possui saldo suficiente

* A transferência deve:

  * Ser validada por um serviço autorizador externo (mock)
  * Ser uma transação (em caso de erro, tudo deve ser revertido)

* Após a transferência:

  * O recebedor deve ser notificado por um serviço externo (mock)

---

## 🔁 Endpoint principal

O desafio sugere um endpoint de transferência:

```json
POST /transfer

{
  "value": 100.0,
  "payer": 4,
  "payee": 15
}
```

---

## 🧠 O que é avaliado

O desafio não busca apenas funcionamento, mas também:

* Organização do código
* Clareza na lógica
* Capacidade de modelar regras de negócio
* Uso de boas práticas (REST, camadas, etc.)
* Capacidade de explicar decisões técnicas

---

## ⚠️ Observações

* Este projeto representa minha **primeira implementação desse tipo de sistema**
* Algumas decisões foram simplificadas com foco em aprendizado
* O desafio permite adaptações e não exige implementação completa de todos os requisitos
* Criação de um saldo inicial implementado no service para permitir o teste das transações

---

## 🚀 Considerações finais

Este projeto foi uma etapa importante no meu aprendizado em backend, permitindo praticar:

* Estruturação de APIs
* Regras de negócio
* Tratamento de erros
* Organização de código

E principalmente:

👉 Aprender a pensar como desenvolvedor backend

---

## 📎 Referência

* [Desafio original no GitHub](https://github.com/PicPay/picpay-desafio-backend?utm_source=chatgpt.com)

---
