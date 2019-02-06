package web;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.joda.time.DateTime;
import org.omnifaces.cdi.GraphicImageBean;

import com.ibm.wsdl.util.IOUtils;

import dao.IrdvLocalDao;
import metier.entities.CertiJaugeauge;
import metier.entities.CertificateNonScdp;
import metier.entities.Holliday;
import metier.entities.Rdv;
import metier.entities.Role;
import metier.entities.User;

@ManagedBean(name="rdvMB")
@RequestScoped
public class RdvMB {
	@EJB
	private IrdvLocalDao metier;
	private Long idrdv;
	private String nom_cli;
	private Long numcerti;
	private String date_rdv3;
	private Date date_rdv;
	private String num_tele;
	private String num_Imatr;
	private String num_citern;
	private Date date_sms;
	private String nom_photo;
	private Date date_rdv2;
//	private Byte[] foto;
	private String heureRdv;
	private String Status;
	private int cpt=0;
	private String state;
	private String type_rdv;
	private String Nom_Constructeur;
	private String Num_abrobation;
	private Integer Capa_nominal;
	private Integer Nbre_compartiment;
	private Rdv rdvv;
	private Holliday h;
	private User u;
	private Role r;
	private CertificateNonScdp certi;
	private DataModel<Role> roles;
	private DataModel<User> users;
	private DataModel<CertificateNonScdp> certis;
	private DataModel<Rdv> Rdvs;
	private DataModel<Holliday> hollies;
	private String nom_jour_ferie;
	private String date_jour_ferie;
	private String login;
	private String password;
	private String role;
	private String dateJaug;
	
	
	public String getDate_rdv3() {
		return date_rdv3;
	}
	public void setDate_rdv3(String date_rdv3) {
		this.date_rdv3 = date_rdv3;
	}
	
	
	public Role getR() {
		return r;
	}
	public void setR(Role r) {
		this.r = r;
	}
	public DataModel<Role> getRoles() {
		if(roles==null)
		{
			roles=new ListDataModel<Role>();
			roles.setWrappedData(metier.ListRole());
		}
		return roles;
	}
	public void setRoles(DataModel<Role> roles) {
		this.roles = roles;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public DataModel<User> getUsers() {
		if(users==null)
		{
			users=new ListDataModel<User>();
			users.setWrappedData(metier.ListUser());
		}
		return users;
	}
	public void setUsers(DataModel<User> users) {
		this.users = users;
	}
	public DataModel<Holliday> getHollies() {
		if (hollies == null) {
			hollies = new ListDataModel<Holliday>();
			hollies.setWrappedData(metier.ListHolliday());
		}
		return hollies;
	}
	public void setHollies(DataModel<Holliday> hollies) {
		this.hollies = hollies;
	}
	public DataModel<Rdv> getRdvs() {
		if (Rdvs == null) {
			Rdvs = new ListDataModel<Rdv>();
			Rdvs.setWrappedData(metier.List_Rdv());
		}
		return Rdvs;
	}
	public void setRdvs(DataModel<Rdv> rdvs) {
		Rdvs = rdvs;
	}
	
	public DataModel<CertificateNonScdp> getCertis() {
		if(certis==null){
			certis=new ListDataModel<CertificateNonScdp>();
			certis.setWrappedData(metier.ListesCertificatNonScdp());
		}
		return certis;
	}
	public void setCertis(DataModel<CertificateNonScdp> certis) {
		this.certis = certis;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getDate_rdv2() {
		return date_rdv2;
	}
	public void setDate_rdv2(String date_rdv3) {
		
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-mm-dd");
		if(date_rdv3!=null){
			try {
				this.date_rdv2 = formatter.parse(date_rdv3);
				DateTime dattime=new DateTime(date_rdv2);
				date_rdv2=dattime.toDate();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			
				DateTime dattime=new DateTime();
				date_rdv2=dattime.toDate();
		}
		}
		
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Long getIdrdv() {
		return idrdv;
	}
	public void setIdrdv(Long idrdv) {
		this.idrdv = idrdv;
	}
	public String getNom_cli() {
		return nom_cli;
	}
	public void setNom_cli(String nom_cli) {
		this.nom_cli = nom_cli;
	}
	public Date getDate_rdv() {
		return date_rdv;
	}
	public void setDate_rdv(Date date_rdv) {
		this.date_rdv = date_rdv;
	}
	
	public Integer getCpt() {
		return cpt;
	}
	public void setCpt(Integer cpt) {
		this.cpt = cpt;
	}
	public String getNum_tele() {
		return num_tele;
	}
	public void setNum_tele(String num_tele) {
		this.num_tele = num_tele;
	}
	public String getNum_Imatr() {
		return num_Imatr;
	}
	public void setNum_Imatr(String num_Imatr) {
		this.num_Imatr = num_Imatr;
	}
	public String getNum_citern() {
		return num_citern;
	}
	public void setNum_citern(String num_citern) {
		this.num_citern = num_citern;
	}
	public Date getDate_sms() {
		return date_sms;
	}
	public void setDate_sms(Date date_sms) {
		this.date_sms = date_sms;
	}
	public String getNom_photo() {
		return nom_photo;
	}
	public void setNom_photo(String nom_photo) {
		this.nom_photo = nom_photo;
	}
	public String getHeureRdv() {
		return heureRdv;
	}
	public void setHeureRdv(String heureRdv) {
		this.heureRdv = heureRdv;
	}
	
	public String getNom_Constructeur() {
		return Nom_Constructeur;
	}
	public void setNom_Constructeur(String nom_Constructeur) {
		Nom_Constructeur = nom_Constructeur;
	}
	public String getNum_abrobation() {
		return Num_abrobation;
	}
	public void setNum_abrobation(String num_abrobation) {
		Num_abrobation = num_abrobation;
	}
	public Integer getCapa_nominal() {
		return Capa_nominal;
	}
	public void setCapa_nominal(Integer capa_nominal) {
		Capa_nominal = capa_nominal;
	}
	public Integer getNbre_compartiment() {
		return Nbre_compartiment;
	}
	public void setNbre_compartiment(Integer nbre_compartiment) {
		Nbre_compartiment = nbre_compartiment;
	}
	
	public String getType_rdv() {
		return type_rdv;
	}
	public void setType_rdv(String type_rdv) {
		this.type_rdv = type_rdv;
	}
	
	public Rdv getRdvv() {
		return rdvv;
	}
	public void setRdvv(Rdv rdvv) {
		this.rdvv = rdvv;
	}
	
	public String getNom_jour_ferie() {
		return nom_jour_ferie;
	}
	public void setNom_jour_ferie(String nom_jour_ferie) {
		this.nom_jour_ferie = nom_jour_ferie;
	}
	public String getDate_jour_ferie() {
		return date_jour_ferie;
	}
	public void setDate_jour_ferie(String date_jour_ferie) {
		this.date_jour_ferie = date_jour_ferie;
	}
	
	public String getDateJaug() {
		return dateJaug;
	}
	public void setDateJaug(String dateJaug) {
		this.dateJaug = dateJaug;
	}
	public String creerRdv()
	{
		Date dateRdv=metier.Getdaterdv();
		Date datenextrdv=metier.Getnextdate(dateRdv);
		Date datesms=metier.Getdatesms(datenextrdv);
		Rdv rdvv=new Rdv(dateRdv, datenextrdv,heureRdv,nom_cli,num_tele,num_Imatr, num_citern,datesms, nom_photo,type_rdv,Nom_Constructeur,Num_abrobation,Capa_nominal,Nbre_compartiment);
		if(metier.Creer_Rdv(rdvv)){
			setState("Enregistrement avec Success!!!!!!!!!!!!!!!");
		return state;
		}
		else{
			setState("Echec D'Enregistrement");
			return state;
		}
	}
	public  void Obtenir_Rdv()
	{
		setRdvv(metier.Obtenir_Rdv(idrdv));
		
	}
	public void deleteRdv()
	{
		metier.Supp_Rdv(idrdv);
	}
	public List<Rdv> getListAllRdv()//listes de tous les RDV dans le systeme
	{
	  List<Rdv> rdv=new ArrayList<Rdv>();	
	  rdv=metier.List_Rdv();
	  return rdv;
	}
	public List<Rdv> getListByDay()//fonction permettant d'obtenir la liste de rendez-vous par date
	{
		
		return metier.list_RdvByDate(new DateTime(date_rdv3).toDate());
	}
	public String getLastDate()//fonction permettant de calculer la dernier date du systeme
	{
		Date dateRdv=metier.Getdaterdv();//fonction renvoyant la date suivant du rendez-vous du systeme
		return metier.GetlastDaterdv(dateRdv);
		
	}
  
	public List<Rdv> getListByStatus()
	{
		setCpt(metier.ListRdvByStatus(Status).size());
		return metier.ListRdvByStatus(Status);
	}
	public String updateRdv()
	{
		
		metier.Modifier_Rdv(rdvv);
		Rdvs.setWrappedData(metier.List_Rdv());
		return "listesRdv";
	}
	public String editerRdv()
	{
		Rdvs=getRdvs();
		rdvv=new Rdv();
		rdvv=(Rdv) Rdvs.getRowData();
		return "EditRdv";
	}
	
	public String InsererJourFerier()
	{ 
		DateTime dt=new DateTime(date_jour_ferie);
		String sd=dt.getDayOfMonth()+" "+dt.monthOfYear().getAsText(Locale.FRENCH);
		Holliday h=new Holliday(nom_jour_ferie,sd,new DateTime(date_jour_ferie).toDate() );
		metier.CreerHolliday(h);
		return null;
	}
	public List<Holliday> getListHolliday()
	{
		return metier.ListHolliday();
	}
	public String editerHolliday()
	{
		hollies=getHollies();
		h=new Holliday();
		h=(Holliday) hollies.getRowData();
		return "EditHolliday";
	}
	public String updateHolliday()
	{
		metier.UpdateHolliday(h);
		hollies.setWrappedData(metier.ListHolliday());
		return "listesHolliday";
	}
	public String deleteHolliday()
	{
		//System.out.println("yesss");
		hollies=getHollies();
		Holliday ho=(Holliday)hollies.getRowData();
		metier.DeleteHolliday(ho.getIdHolliday());
		hollies.setWrappedData(metier.ListHolliday());
		return null;
	}
	public List<CertificateNonScdp> getListCertificatNonScdp()
	{
		
		return metier.ListesCertificatNonScdp();
	}
	public void deleteCertiNonSdp()
	{
		//System.out.println("yesss");
		certis=getCertis();
		certi=(CertificateNonScdp)certis.getRowData();
		metier.DeleteCertificateNSCD(certi.getId_Certificate());
		certis.setWrappedData(metier.ListesCertificatNonScdp());
		
	}
	public void CreerUser()
	{ 
		User user=new User(login,password);
		metier.CreerUser(user);
	}
	public List<User> getListUser()
	{
		return metier.ListUser();
	}
	public String deleteUser()
	{
		//System.out.println("yesss");
		users=getUsers();
		User u=(User)users.getRowData();
		metier.DeleteUser(u.getIdUser());
		users.setWrappedData(metier.ListUser());
		return null;
	}
	public String editerUser()
	{
		users=getUsers();
		u=new User();
		u=(User) users.getRowData();
		return "EditUser";
	}
	public String updateUser()
	{
		
		metier.UpdateUser(u);
		users.setWrappedData(metier.ListUser());
		return "listesUsers";
	}
	public void CreerRole()
	{
		Role r=new Role(role);
		metier.CreeRole(r);
	}
	public List<Role> getListRole()
	{
		return metier.ListRole();
	}
	public String deleteRole()
	{
		//System.out.println("yesss");
		roles=getRoles();
		Role r=(Role)roles.getRowData();
		metier.DeleteRole(r.getIdRole());
		roles.setWrappedData(metier.ListRole());
		return null;
	}
	public String editerRole()
	{
		roles=getRoles();
		r=new Role();
		r=(Role) roles.getRowData();
		return "EditRole";
	}
	public String updateRole()
	{
		
		metier.UpdateRole(r);
		roles.setWrappedData(metier.ListRole());
		return "listesRoles";
	}
	public byte[] obtenirPhoto(Long id)throws IOException
	{
		
	/*	String [] testess={"jojo","toto"};
		System.out.println(testess);
		CertificateNonScdp certi=metier.ObtenirCertificat(id);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).length);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())));
		System.out.println(certi.getPhoto().toString());
		System.out.println(certi.getPhoto()+" "+certi.getPhoto().length);
		return org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).clone();*/
		CertificateNonScdp certi=metier.ObtenirCertificat(id);
        byte[] decodedString = Base64.getDecoder().decode(new String(certi.getPhoto()).getBytes("UTF-8"));
		byte[] name =Base64.getDecoder().decode(decodedString);


        System.out.println(new String(certi.getPhoto()).getBytes("UTF-8"));
        System.out.println(new String(decodedString));
        // byte[] decodedString= Base64.getMimeDecoder().decode(new String(certi.getPhoto()).getBytes("UTF-8"));
		return name;
		
	}
	public String SearchRdvByImmaCiter()

	{
		List<Rdv> rdv=metier.SearchByImmaAndCiter(num_Imatr,num_citern);
		if(rdv.size()==0)
		{
			setState("Ce camion n'a pas de rendez-vous prise");
			return state;
		}
		else{
			DateTime dat=new DateTime(rdv.get(0).getDate_rdv());
			System.out.println(dat.toDate().compareTo(new DateTime().toDate())==0);
			System.out.println(dat.toDate()+" "+rdv.get(0).getDate_rdv() +" "+new DateTime().toDate());
	        String dateRdv=dat.getDayOfMonth()+"-"+dat.monthOfYear().getAsText(Locale.FRENCH)+"-"+dat.getYear();
	        DateTime dett=new DateTime();
	        String datesys=dett.getDayOfMonth()+"-"+dett.monthOfYear().getAsText(Locale.FRENCH)+"-"+dett.getYear();

			System.out.println(datesys+" "+dateRdv);

			if(datesys.equals(dateRdv))
			{

				setState("Vous etes entraint de confirmer la presence du camion Immatriculer"
			            +rdv.get(0).getNum_immatri()+" "+ " numero de citerne "+rdv.get(0).getNum_immatri()
			            +"au sein de la station SCDP");
				rdv.get(0).setStatusRdv("PRESENT");
				metier.Modifier_Rdv(rdv.get(0));
				return state;
			}else{
				if(dat.compareTo(new DateTime())>0)
				{
					 
							setState(" Impossible de valider la presence de ce camion dans cette station");
							return state;
				}else{
					 
							setState("impossible de modifier le status de ce rendez-vous la date de confirmation expiré");
							return state;
				}
			}
			
		}
	}
	public void creerCertificat()
	{
		DateTime dateJaugeage= new DateTime(dateJaug);
		CertiJaugeauge c=new CertiJaugeauge(nom_cli,num_Imatr,Num_abrobation,num_citern,type_rdv,Nbre_compartiment,Capa_nominal,dateJaugeage.toDate());
		metier.CeerCertijaug(c);
		
	}
	public List<CertiJaugeauge> getListCertiJaugage()
	{
		return metier.ListCertiJaug();
	}
	public byte[] obtenirPhotoAvant(Long id)throws IOException
	{
		
	/*	String [] testess={"jojo","toto"};
		System.out.println(testess);
		CertificateNonScdp certi=metier.ObtenirCertificat(id);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).length);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())));
		System.out.println(certi.getPhoto().toString());
		System.out.println(certi.getPhoto()+" "+certi.getPhoto().length);
		return org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).clone();*/
		System.out.println("Avant");

		Rdv r=metier.Obtenir_Rdv(id);
		System.out.println(r.getNum_rdv());
		byte[] decodedString = Base64.getDecoder().decode(new String(r.getPhotoFace()).getBytes("UTF-8"));
		byte[] name =Base64.getDecoder().decode(decodedString);
		return name;
		
	}
	public byte[] obtenirPhotoArriere(Long id)throws IOException
	{
		
	/*	String [] testess={"jojo","toto"};
		System.out.println(testess);
		CertificateNonScdp certi=metier.ObtenirCertificat(id);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).length);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())));
		System.out.println(certi.getPhoto().toString());
		System.out.println(certi.getPhoto()+" "+certi.getPhoto().length);
		return org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).clone();*/
		System.out.println("Arriere");

		Rdv r=metier.Obtenir_Rdv(id);
		System.out.println(r.getNum_rdv());
		byte[] decodedString = Base64.getDecoder().decode(new String(r.getPhotoArriere()).getBytes("UTF-8"));
		
		byte[] name =Base64.getDecoder().decode(decodedString);
		return name;		
	}
	public byte[] obtenirPhotoProfil(Long id)throws IOException
	{
		
	/*	String [] testess={"jojo","toto"};
		System.out.println(testess);
		CertificateNonScdp certi=metier.ObtenirCertificat(id);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).length);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())));
		System.out.println(certi.getPhoto().toString());
		System.out.println(certi.getPhoto()+" "+certi.getPhoto().length);
		return org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).clone();*/
		System.out.println("Profil");

		Rdv r=metier.Obtenir_Rdv(id);
		System.out.println(r.getNum_rdv());
        byte[] decodedString = Base64.getDecoder().decode(new String(r.getPhotoProfil()).getBytes("UTF-8"));
		System.out.println(new String(decodedString));

        byte[] name =Base64.getDecoder().decode(decodedString);
		return name;
		
	}
	public byte[] obtenirCertificat(Long id)throws IOException
	{
		
	/*	String [] testess={"jojo","toto"};
		System.out.println(testess);
		CertificateNonScdp certi=metier.ObtenirCertificat(id);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).length);
		System.out.println(org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())));
		System.out.println(certi.getPhoto().toString());
		System.out.println(certi.getPhoto()+" "+certi.getPhoto().length);
		return org.apache.poi.util.IOUtils.toByteArray(new ByteArrayInputStream(certi.getPhoto())).clone();*/
		System.out.println("Certificat");

		CertificateNonScdp c=metier.ObtenirCertificat(id);
		System.out.println(c.getId_Certificate());
		byte[] decodedString = Base64.getDecoder().decode(new String(c.getPhoto()).getBytes("UTF-8"));
		
		byte[] name =Base64.getDecoder().decode(decodedString);
		return name;		
	}
	public String OuvrirPhotoCertificat()
	{
		
		certis=getCertis();
		certi=new CertificateNonScdp();
		
		certi=(CertificateNonScdp)certis.getRowData();
	
		return "OpenFile";
	}
}
