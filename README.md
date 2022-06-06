# API-SEND-MAIL

MICRO SERVIÇO PARA ENVIO DE E-MAIL.

JAVA 8.

SPRING AMQP

SPRING VALIDATION

JPA

HIBERNATE

RABBITMQ

# APPLICATION.PROPERTIES.

  Onde os campos  abaixo devem ser preenchidos com os acessos do seu GMAIL. Para o campo senha deve seguir essa documentação do google.

 https://support.google.com/accounts/answer/185833

spring.mail.username=

spring.mail.password=

Para criar instacnia do RABBITAMQP - https://customer.cloudamqp.com/


# MICRO SERVIÇO POST.
 Utilizar a URL : http://localhost:8180/api/send-email

 Exemplo do Body:
 {

    "ownerRef" : "tezte",

    "emailFrom" : "teste@hotmail.com",

    "emailTo" : "teste@hotmail.com,

    "subject" : "TESTE DE E-MAIL" ,

    "text" : "TEXTO INTERNO" 

}
