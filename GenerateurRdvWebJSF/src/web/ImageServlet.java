package web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IrdvLocalDao;
import metier.entities.CertificateNonScdp;

@WebServlet("/Image/*")
public class ImageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@EJB
private IrdvLocalDao metier;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
	String Image= request.getParameter("id");
	Long ImageId=Long.valueOf(Image);
	CertificateNonScdp cert=metier.ObtenirCertificat(ImageId);
	byte[] imageBytes = null;
	imageBytes=cert.getPhoto();
	response.getOutputStream().write(imageBytes);
    response.getOutputStream().close();
	
}

}
