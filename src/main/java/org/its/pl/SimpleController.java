//package org.its.pl;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//@RequestMapping("/api/simple")
//public class SimpleController {
//
//    List<Utente> listaUtenti = new ArrayList<Utente>();
//
//    //SIMPLE
//    @RequestMapping(
//            method = RequestMethod.GET,
//            produces = "text/html")
//
//    @ResponseBody
//    public String sayHello() {
//        return "Hello i'm a server!";
//    }
//
////    //ID
////    @RequestMapping(
////            path = "/{id}",
////            method = RequestMethod.GET,
////            produces = "text/html")
////
////    @ResponseBody
////    public String sayHelloTo(@PathVariable("id") String helloTarget) {
////        return "Hello " + helloTarget;
////    }
////
////    //QUERY
////    @RequestMapping(
////            path = "/query",
////            method = RequestMethod.GET,
////            produces = "text/html")
////    @ResponseBody
////    public String sayHelloQuery(@RequestParam("target") String helloTarget) {
////        return "Hello " + helloTarget;
////    }
//
//    //UTENTE
//    @RequestMapping(
//            path = "/utente",
//            method = RequestMethod.GET,
//            produces = "application/json")
//
//    @ResponseBody
//    public Utente showUtente() {
//        Utente result = new Utente();
//        result.setId(1);
//        result.setName("test");
//        return result;
//    }
//
//    //CRUDs
//    //getALL
//    @RequestMapping(
//            path = "/utenti",
//            method = RequestMethod.GET,
//            produces = "application/json")
//
//    @ResponseBody
//    public List<Utente> getAllUtenti() {
//        List<Utente> result = new ArrayList<Utente>();
//        return result;
//    }
//
//    //getById
//    @RequestMapping(
//            path = "/utente/{id}",
//            method = RequestMethod.GET,
//            produces = "application/json")
//
//    @ResponseBody
//    public Utente getUtenteById(@PathVariable("id") String id) {
//        Utente user = new Utente();
//
//        for (Utente utente : listaUtenti) {
//            if (utente.getId() == Integer.parseInt(id)) {
//                user = utente;
//            }
//        }
//        return  user;
//    }
//
//    //post
//    @RequestMapping(
//            path = "/utente/post",
//            method= RequestMethod.POST,
//            produces="application/json",
//            consumes = "application/json")
//    @ResponseBody
//    public Utente postUtente(@RequestBody Utente request) {
//        Utente response = new Utente();
//        response.setId(request.getId());
//        response.setName(request.getName());
//        listaUtenti.add(response);
//        return response;
//    }
//
//    //delete
//    @RequestMapping(
//            path = "/utente/{{idUtente}}",
//            method= RequestMethod.DELETE,
//            produces="application/json")
//
//    @ResponseBody
//    public Boolean deleteUtente(@PathVariable("id") String id) {
//        List<Utente> result = new ArrayList<Utente>();
//        Utente user = new Utente();
//
//        for (Utente utente : result) {
//            if (Integer.toString(utente.getId()) == id) {
//                user = utente;
//            }
//        }
//
//        if (result.remove(user)){
//            return  true;
//        } else  return  false;
//    }
//
//
//    //put
//    @RequestMapping(
//            path = "/utente/{{idUtente}}",
//            method= RequestMethod.POST,
//            produces="application/json",
//            consumes = "application/json")
//    @ResponseBody
//    public void putUtente(@PathVariable("id") String idUtente, @RequestBody Utente request) {
//        Utente user = new Utente();
//
//        for (Utente utente : listaUtenti) {
//            if (Integer.toString(utente.getId()) == idUtente) {
//                user = utente;
//            }
//        }
//        listaUtenti.remove(user);
//        Utente utentePut = new Utente(request.getId(), request.getName());
//        listaUtenti.add(utentePut);
//    }
//
//}
