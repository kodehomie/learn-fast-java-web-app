//package org.justinhoang.controller;
//
//import org.justinhoang.entity.Search;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet(name = "userSearchResults",
//            urlPatterns = {"/user-search-results"})
//public class UserSearchResults extends HttpServlet
//{
//
//    public void init() throws ServletException
//    {
//    }
//
//    public void doGet(HttpServletRequest request,
//                      HttpServletResponse response) throws
//                                                                                ServletException,
//                                                                                IOException
//    {
//        HttpSession       httpsession;
//        String            url;
//        String            searchTerm;
//        String            searchType;
////        UserDirectory     userDirectory;
//        Search            search;
//        String            SearchMessage;
//        RequestDispatcher dispatcher;
//        httpsession   = request.getSession();
//        url           = null;
//        searchTerm    = request.getParameter("searchTerm");
//        searchType    = request.getParameter("searchType");
////        userDirectory = (UserDirectory) getServletContext().getAttribute(
////                "userDirectory");
//        search        = new Search();
//        search.setEnteredSearchTerm(searchTerm);
//        search.setEnteredSearchType(searchType);
//        SearchMessage = "";
//        httpsession.setAttribute("searchMessage", SearchMessage);
//        if ((search.getEnteredSearchTerm() == null ||
//             search.getEnteredSearchTerm().equals("")) &
//            (search.getEnteredSearchType() == null ||
//             search.getEnteredSearchType().equals("")))
//        {
//            SearchMessage = "Please enter " + "Search Term and Search Type.";
//            httpsession.setAttribute("searchMessage", SearchMessage);
//            url = "/user-search.jsp";
//        }
//        else if (search.getEnteredSearchTerm() == null ||
//                 search.getEnteredSearchTerm().equals(""))
//        {
//            SearchMessage = "Please enter Search Term.";
//            httpsession.setAttribute("searchMessage", SearchMessage);
//            url = "/user-search.jsp";
//        }
//        else if (search.getEnteredSearchType() == null ||
//                 search.getEnteredSearchType().equals(""))
//        {
//            SearchMessage = "Please enter Search Type.";
//            httpsession.setAttribute("searchMessage", SearchMessage);
//            url = "/user-search.jsp";
//        }
//        else
//        {
//            search = userDirectory.searchUserDatabase(search);
//            httpsession.setAttribute("search", search);
//            if (!search.getIsUserFound())
//            {
//                SearchMessage = "User is not found.";
//                httpsession.setAttribute("searchMessage", SearchMessage);
//            }
//            url = "/user-search-results.jsp";
//        }
//        dispatcher = getServletContext().getRequestDispatcher(url);
//        dispatcher.forward(request, response);
//    }
//
//    public void doPost(HttpServletRequest request,
//                       HttpServletResponse response) throws
//                                                                                 ServletException,
//                                                                                 IOException
//    {
//    }
//
//    public void destroy()
//    {
//    }
//}
//
