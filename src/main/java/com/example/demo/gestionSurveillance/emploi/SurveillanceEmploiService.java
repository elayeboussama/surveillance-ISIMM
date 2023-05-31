package com.example.demo.gestionSurveillance.emploi;


import com.example.demo.Doa.EmploiRepository;
import com.example.demo.Doa.EnseignantMatiereRepository;
import com.example.demo.Doa.EnseignantRepository;
import com.example.demo.gestionSurveillance.emploi.dto.*;
import com.example.demo.entities.*;
import com.example.demo.gestionSurveillance.emploi.dto.Section;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTORequest;
import com.example.demo.gestionSurveillance.enseignant.dto.EnseignantDTOResponse;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

import static com.example.demo.gestionSurveillance.emploi.dto.mapper.EmploiMappers.mapEmploiToDTORequest;
import static com.example.demo.gestionSurveillance.emploi.dto.mapper.EmploiMappers.mapEmploiToDTOResponse;
import static com.example.demo.gestionSurveillance.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTORequest;
import static com.example.demo.gestionSurveillance.enseignant.dto.mapper.EnseignantMappers.mapEnseignantToDTOResponse;

@Service
@RequiredArgsConstructor
public class SurveillanceEmploiService {
    @Autowired
    private EnseignantMatiereRepository enseignantMatiereRepository;

    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private EmploiRepository emploiRepository;
    public List<EmploiDTOResponse> findAllEmploiService(){
        // convertir list emploi -> list emploi DTOs
        List<Emploi> emplois = emploiRepository.findAll();;


        List<EmploiDTOResponse> emploiDTORespons = new ArrayList<>() ;
        for (Emploi emploi : emplois) {
            EmploiDTOResponse emploiDTOResponse = mapEmploiToDTOResponse(emploi);
            emploiDTORespons.add(emploiDTOResponse);
        }
        return emploiDTORespons;
    }

    public void insertEmploiService(EmploiDTORequest emploiRequest){
        Emploi emploi = mapEmploiToDTORequest(emploiRequest, enseignantRepository);
        emploiRepository.save(emploi);
    }



    public ResponseEntity<String> deleteEmploiService(Long id){
        Optional<Emploi> emplois  = emploiRepository.findById(id);

        if (emplois.isPresent()) {
            Emploi emploi = emplois.get();
            emploiRepository.delete(emploi);
            return ResponseEntity.ok("emploi with ID " + id + " deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("emploi with ID " + id + " not found");
        }
    }


    ArrayList<Enseignant> generateEns(){

        ArrayList<Enseignant> ensList = new ArrayList<>();
        // create enseignant
        Enseignant ens1 = new Enseignant("malek");
        Enseignant ens2 = new Enseignant("lazhar");
        Enseignant ens3 = new Enseignant("graeit");
        Enseignant ens4 = new Enseignant("gzara");

        ens1.addNotAvailable(LocalDate.of(2023,3,13));

        // create Matieres
        Matiere m1 =  new Matiere("Mobile");
        Matiere m2 = new Matiere("UML");
        Matiere m3 = new Matiere("AI");
        Matiere m4 = new Matiere("ML");

        // adding matiere to ens

        EnseignantMatiere ensmat1 = new EnseignantMatiere(ens1, m1);
        EnseignantMatiere ensmat2 = new EnseignantMatiere(ens2, m2);
        EnseignantMatiere ensmat3 = new EnseignantMatiere(ens3, m3);
        EnseignantMatiere ensmat4 = new EnseignantMatiere(ens4, m4);

//        ens1.getMatieres().add(m1);
//        ens2.getMatieres().add(m2);
//        ens3.getMatieres().add(m3);
//        ens4.getMatieres().add(m4);

        ensList.add(ens1);
        ensList.add(ens2);
        ensList.add(ens3);
        ensList.add(ens4);

        return ensList;
    }
    ArrayList<Matiere> generateMatieres(){

        ArrayList<Matiere> matList = new ArrayList<>();

        // create Matieres
        Matiere m1 =  new Matiere("Mobile");
        Matiere m2 = new Matiere("UML");
        Matiere m3 = new Matiere("AI");
        Matiere m4 = new Matiere("ML");
        Matiere m5 = new Matiere("framac");
        Matiere m6 = new Matiere("algorithme");
        Matiere m7 = new Matiere("C");
        Matiere m8 = new Matiere("Java");
        Matiere m9 = new Matiere("Python");
        Matiere m10 = new Matiere("BD");




        matList.add(m1);
        matList.add(m2);
        matList.add(m3);
        matList.add(m4);
        matList.add(m5);
        matList.add(m6);
        matList.add(m7);
        matList.add(m8);
        matList.add(m9);
        matList.add(m10);


        return matList;
    }
    ArrayList<ReqMatiere> extractRequest(EmploiRequestForGenerating request){
        ArrayList<ReqMatiere> reqList = new ArrayList<>();
        for (Section s : request.sections()){
            reqList.addAll(s.matieres());
//            reqList.addAll(s.subjects());
        }
        return reqList;
    }
    Matiere getMatiereByName(String name,ArrayList<Matiere> matieres){
        for (Matiere m : matieres){
            if (m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    LocalDateTime getTimeBySession(int sessionNumber, String state, Date date, String type){
        if(state.equals("start")){
            switch (sessionNumber) {
                case 1 :
                    return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 8, 30, 0);

                case 2 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 10, 30, 0);


                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 10, 0, 0);


                    }
                case 3 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 13, 0, 0);

                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 11, 30, 0);

                    }

                case 4 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 15, 0, 0);

                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 13, 30, 0);

                    }

                case 5 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 17, 0, 0);

                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 15, 0, 0);

                    }

                default: return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 0, 0, 0);
            }

        } else if(state.equals("end")){
            switch (sessionNumber) {
                case 1 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 10, 0, 0);


                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 9, 30, 0);


                    }

                case 2 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 12, 0, 0);


                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 11, 0, 0);


                    }
                case 3 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 14, 30, 0);

                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 12, 30, 0);

                    }

                case 4 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 16, 30, 0);

                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 14, 30, 0);

                    }

                case 5 :
                    if(type.equals("exam")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 18, 30, 0);

                    }else if(type.equals("ds")){
                        return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 16, 0, 0);

                    }
                default: return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 0, 0, 0);
            }
        }
         return LocalDateTime.of(date.getYear(), date.getMonth(), date.getDay(), 0, 0, 0);
    }
    ArrayList<Seance> generateSeances(ArrayList<ReqMatiere> reqMatieres, ArrayList<Matiere> matieres, String type){
        ArrayList<Seance> seances = new ArrayList<>();
        for (ReqMatiere rm : reqMatieres){
//            if(rm.isIncluded()){
            Matiere m = getMatiereByName(rm.name(),matieres);
//            Seance seance = new Seance("seance"+rm.name(),rm.date_ds(),rm.temps_debut(),rm.temps_fin(),m);
            Seance seance = new Seance("seance"+rm.name(),rm.date(),getTimeBySession(rm.sessionNumber(),"start", rm.date(), type),getTimeBySession(rm.sessionNumber(),"end", rm.date(), type),m, rm.sessionNumber());
            seances.add(seance);
            //}
        }
        return seances;
    }
    ArrayList<Seance> getSeanceByEnseignant(Enseignant e,ArrayList<Seance> seances ){
        ArrayList<Seance> newList = new ArrayList<>();
        for (Seance s : seances){
            for (Enseignant en : s.getEnseignants()){
               if (en.getNom().equals(e.getNom())){
                   newList.add(s);
               }
            }

        }

        return newList;
    }
    boolean isNotAtTheSameTime(Enseignant e,ArrayList<Seance> seances,Seance seance ){
        ArrayList<Seance> newList = getSeanceByEnseignant(e,seances);

        for (Seance s : newList){
                if (s.getTempDebut().isEqual(seance.getTempFin())){
                    return false;
                }
            }
        return true;

    }

    public ArrayList<Matiere> getMatieresByEnseignant(Enseignant ens ){
        return  (ArrayList<Matiere>) enseignantMatiereRepository.findByEnseignantId(ens.getId());
    }
    boolean ensAvailable(Enseignant e, Date date) {
        return true;
    }
        boolean isValid(Enseignant e, Seance s,ArrayList<Seance> seances){
        boolean exist = false;
            for (Matiere m : getMatieresByEnseignant(e)){
            if(ensAvailable(e, s.getDate()))
            if (m.getName().equals(s.getMatiere().getName())) {
                exist = true;
                break;
            }
        }
        return !exist
                && s.getEnseignants().size() < 2
                && isNotAtTheSameTime(e,seances,s)
                && getSeanceByEnseignant(e,seances).size()<2
                && !e.getNotAvailable().contains(s.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    }
    ArrayList<Seance> handlSeances(ArrayList<Seance> seances,ArrayList<Enseignant> ensList){
        for(Seance s:seances){
            for (Enseignant e : ensList){
                if (isValid(e, s,seances)){
                    s.getEnseignants().add(e);
                }
            }

        }
        return seances;
    }
//    Date getEmploiStartDate(ArrayList<Seance> seances){
//        Date startDate = seances.get(0).getDate_ds();
//        for (Seance s : seances){
//            if (s.getDate_ds().before(startDate)){
//                startDate = s.getDate_ds();
//            }
//        }
//        return startDate;
//    }
//    Date getEmploiEndDate(ArrayList<Seance> seances){
//        Date endDate = seances.get(0).getDate_ds();
//        for (Seance s : seances){
//            if (s.getDate_ds().after(endDate)){
//                endDate = s.getDate_ds();
//            }
//        }
//        return endDate;
//    }
    ArrayList<Emploi> generateEmploi(ArrayList<Seance> seances,ArrayList<Enseignant> ensList, Date dateDebut, Date dateFin){
        ArrayList<Emploi> emploiList = new ArrayList<>();
        for (Enseignant e : ensList){
            ArrayList<Seance> currentSeances = getSeanceByEnseignant(e,seances);
//            Date startDate = getEmploiStartDate(currentSeances);
//            Date endDate = getEmploiEndDate(currentSeances);
            Date startDate = dateDebut;
            Date endDate = dateFin;
            Emploi emp = new Emploi(startDate,endDate,e);
            Set<Seance> setCurrentSeances = new HashSet<>(currentSeances);
            emp.setSeances(setCurrentSeances);
            emploiList.add(emp);
        }
        return emploiList;
    }
    public JSONObject createEmploi(EmploiRequestForGenerating request) {
        String typeOfEmploi = "exam";
        ArrayList<Enseignant> ensList = generateEns();
        ArrayList<Matiere> matList = generateMatieres();
        ArrayList<ReqMatiere> reqList = extractRequest(request);
        ArrayList<Seance> seances = generateSeances(reqList,matList, typeOfEmploi);
        ArrayList<Seance> handledSeances = handlSeances(seances,ensList);
        ArrayList<Emploi> emplois = generateEmploi(handledSeances,ensList,request.dateDebut(),request.dateFin());
        for (Emploi emp:emplois){
            System.out.println("Emploi : ");
            System.out.println("Enseignant :"+ emp.getEnseignant().getNom());
            System.out.println("startDate: "+emp.getDateDebut());
            System.out.println("endDate: "+emp.getDateFin());
            for (Seance s:emp.getSeances()){
                System.out.println("Seance: "+s.getMatiere().getName() );
            }

            System.out.println("--------------------------------------------------------------------------");

        }

        JSONObject responseJSON = new JSONObject();


        ArrayList<JSONObject> emploiByEns = new ArrayList<>();
        for (Emploi emp:emplois){
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("Enseignant", emp.getEnseignant().getNom());
            map.put("startDate", emp.getDateDebut());
            map.put("endDate", emp.getDateFin());

            ArrayList<JSONObject> seancesRegenarated = new ArrayList<>();
            for (Seance s : emp.getSeances()){
                JSONObject seanceJSON = new JSONObject();
                seanceJSON.put("date", s.getDate());
                seanceJSON.put("time_start", s.getTempDebut());
                seanceJSON.put("time_end", s.getTempFin());
                seanceJSON.put("name", s.getNom());
                seanceJSON.put("sessionNumber", s.getSessionNumber());
                seancesRegenarated.add(seanceJSON);
            }
            map.put("Seances", seancesRegenarated) ;

            JSONObject emploiForEnsJSON = new JSONObject(map);
            emploiByEns.add(emploiForEnsJSON);


        }
        responseJSON.put("Emploi", emploiByEns);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println(responseJSON);

        return responseJSON;
    }
}
