package br.com.thalison.crudMongodb.service.exception;

public class ObjectNotFoundException extends RuntimeException{

   public ObjectNotFoundException(String msg){
       super(msg);
   }
}
