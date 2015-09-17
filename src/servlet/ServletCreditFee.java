package servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBCreditTuition;
import model.HCreditTuition;

/**
 * Servlet implementation class ServletCreditFee
 */
@WebServlet("/CreditFee")
public class ServletCreditFee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCreditFee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get of credit fee");
		String action = request.getParameter("action");
		String action1 = (String) request.getAttribute("action");
		if(action==null ){
			action = "";
		}else if(action1==null){
			action1="";
		}
		if(action.equalsIgnoreCase("load") || action1.equalsIgnoreCase("load")){
			long creditTuitionId = DBCreditTuition.getLatestFeeID();
			HCreditTuition creditObj = DBCreditTuition.getCreditTuitionFee(creditTuitionId);
			String creditFee = DecimalFormat.getCurrencyInstance().format(creditObj.getCreditFee());
			request.setAttribute("creditFee", creditFee);
			request.setAttribute("action", "load");
			getServletContext().getRequestDispatcher("/CreditFee.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("EditCreditFee")) {
			request.setAttribute("action", "EditCreditFee");
			getServletContext().getRequestDispatcher("/CreditFee.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post of credit fee");
		String newCreditFeeStr = request.getParameter("newCreditFee");
		if(newCreditFeeStr!=null && !newCreditFeeStr.isEmpty()){
			HCreditTuition creditObj = new HCreditTuition();
			double newCreditFee = Double.parseDouble(newCreditFeeStr);
			creditObj.setCreditFee(newCreditFee);
			DBCreditTuition.insert(creditObj);
			String goodMessage = "Congrats!! Tuition Credit Fee changed";
			request.setAttribute("goodMessage", goodMessage);
		}else{
			
			String errorMessage = "Error!! Try Again";
			request.setAttribute("errorMessage", errorMessage);
		}
		request.setAttribute("action", "load");
		doGet(request,response);
	}

}
