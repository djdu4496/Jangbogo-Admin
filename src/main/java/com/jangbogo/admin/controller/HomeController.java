package com.jangbogo.admin.controller;


//@Slf4j
//@Controller
public class HomeController {

//    @GetMapping("/vip")
//    public String vip(HttpServletRequest request, Model model, Authentication authentication) {
//        WebAuthenticationDetails wDetails = (WebAuthenticationDetails) authentication.getDetails();
//        String ipAddress = wDetails.getRemoteAddress();
//        request.setAttribute("ipAddress", ipAddress);
//        return "vip";
//    }
//
//    @GetMapping("/admin")
//    public String admin(HttpServletRequest request, Model model, Authentication authentication) {
//        WebAuthenticationDetails wDetails = (WebAuthenticationDetails) authentication.getDetails();
//        String ipAddress = wDetails.getRemoteAddress();
//        request.setAttribute("ipAddress", ipAddress);
//        return "admin";
//    }
//
//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, Model model, Authentication authentication) {
//        String uri = request.getHeader("Referer");
//
//        log.info("경로 : "+ uri);
//
//        //나중에 로그인 중복 화면을 보여주는 게 아니라 메인 페이지로 이동하도록 한다.
//        if (authentication != null) return "redirect:/";
//
//        //Referer헤더 값이 존재하고 uri가 /login 또는 /login_check 경로일 경우 세션에 prevpage 키로 uri를 저장한다.
//        if (uri != null && !(uri.contains("/login") || uri.contains("/login_check")))
//            request.getSession().setAttribute("prevPage", uri);
//
//        return "login";
//    }
//
//    @RequestMapping("/loginLinkPage")
//    public String loginLinkPage(Model model) {
//        return "loginLinkPage";
//    }
//
//    //로그아웃
//    @GetMapping("/security_logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/";
//    }
//
//    @Autowired
//    SignUpService signUpService;
//
//    @RequestMapping("/signUpView")
//    public String signUpView(Model model) {
//        return "signUpView";
//    }
//
//    @RequestMapping("/signUp")
//    public String signUp(HttpServletRequest request, Model model) {
//        //id, password 제대로 넘어온다.
//        boolean isInserted = signUpService.insertUserInfo(request.getParameter("id"), request.getParameter("password"));
//
//        if (isInserted) return "login";
//
//        else return "signUpView";
//    }
}
