Architecture de l'application : 

https://github.com/alilou1998/NFC_Architecture_Microservices/blob/master/NFC%20Microservices_Architecture_2.pdf

Outils :
- Feign Client
- Zuul 
- Eureka
- JWT Authentication
- Zipkin for request interceptor
- Spring Admin

Test : 

-Authentification : POST -> http://localhost:8183/authenticate

                Body :  {
                          "username":"admin",
                          "password":"admin"
                        }
                Reponse :
                         {
                            jwt:"${your-token}"
                         }
                         
 -Enregistrer du tag : POST -> http://localhost:8183/microservice-tag-register/tagdateregister/add
 
                 Body : [
                          {
                              "m":"TAG-2,13/03/2020 14:30:20"
                          },
                          {
                              "m":"TAG-3,15/03/2020 17:30:20"
                          },
                          {
                              "m":"TAG-1,10/03/2020 18:30:20"
                          }
                        ]
                 Header : Authorization: Bearer ${your-token} 
                 Reponse : -200 (Http.ok)
                           -422 (Http.unprocessableEntity)
                           
 - Employes à temps : POST -> http://localhost:8183/microservice-tag-register/tagdateregister/employeesbytime 
 
                    Body: {
                             "m":"13/03/2020 15:31:20,16/03/2020 14:30:20"//m:"check-in,check-out"
                          }
                    
                        
                        
                        
                        
                        
