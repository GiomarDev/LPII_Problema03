package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Mueble;
import model.muebleModel;

@WebServlet("/insertaMueble")
public class muebleControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			double pre = Double.parseDouble(request.getParameter("Precio")) ;
			int sto = Integer.parseInt(request.getParameter("Stock"));

			
			Mueble obj = new Mueble();
			obj.setPrecio(pre);
			obj.setStock(sto);
			
			muebleModel m = new muebleModel();
			int s = m.insertaMueble(obj);
			if (s>0)
				request.getSession().setAttribute("MENSAJE", "registro exitoso");
			else
				request.getSession().setAttribute("MENSAJE", "registro erróneo");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute("MENSAJE", "registro erróneo");
		} finally {
			response.sendRedirect("RegistraMueble.jsp");
		}
	
	
	}

}
