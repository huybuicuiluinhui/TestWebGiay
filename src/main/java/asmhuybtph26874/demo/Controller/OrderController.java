package asmhuybtph26874.demo.Controller;

import asmhuybtph26874.demo.Model.Account;
import asmhuybtph26874.demo.Model.Order;
import asmhuybtph26874.demo.Model.OrderDetail;
import asmhuybtph26874.demo.Service.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Log4j2
@Controller
public class OrderController {
    @Autowired
    AccountService accountService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;
    @Autowired
    SessionService sessionService;

    @PostMapping("/checkout")
    public String checkout(@RequestParam("address") String address) {
        shoppingCartService.checkOut(address);
        shoppingCartService.clear();
        return "redirect:/asm/product/user";
    }

    @GetMapping("/viewOrder")
    public String view(Model model) {
        if (checkSecurity()) {

            List<Order> list = orderService.findAll();
            model.addAttribute("orders", list);
            return "/product/order/view-order";
        }
        return "redirect:/account/login";


    }

    @GetMapping("/view-order-detail/{id}")
    public String viewDetailOrder(Model model, @PathVariable("id") Integer id) {
        Order order = orderService.findById(id);
        List<OrderDetail> list = orderDetailService.findByHD(order);
        Double total  = orderDetailService.calculateTotalAmountByOrderId(id);
        System.out.println("total"+total);
        model.addAttribute("list", list);
        model.addAttribute("total", total);
        model.addAttribute("order", order);
        return "/product/order/view-order-detail";
    }

    @PostMapping("/thong-ke")
    public String getTopSellingProducts(Model model,@RequestParam(name = "action") String action, @RequestParam(name = "startDate") String start, @RequestParam(name = "endDate") String end) {

        if (checkSecurity()) {
           if(action.equals("search")){
               try {
                   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                   Date startDate = dateFormat.parse(start);
                   Date endDate = dateFormat.parse(end);
                   List<Object[]> topSellingProducts = orderDetailService.getTop10BestSellingProductsByDateRange(startDate, endDate);
                   model.addAttribute("topSellingProducts", topSellingProducts);
                   model.addAttribute("methodSource", "method1");
                   model.addAttribute("type", "table");
                   System.out.println(topSellingProducts);
               } catch (Exception e) {
                   e.printStackTrace();
               }
               return "/product/thongKe/thongKe";
           }
           else if(action.equals("view-chart")){
               try {
                   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                   Date startDate = dateFormat.parse(start);
                   Date endDate = dateFormat.parse(end);
                   List<Object[]> topSellingProducts = orderDetailService.getTop10BestSellingProductsByDateRange(startDate, endDate);
                   List<String> productNames = new ArrayList<>();
                   List<Long> quantities = new ArrayList<>();
                   for (Object[] result : topSellingProducts) {
                       String productName = result[0].toString();
                       Long quantity = (Long) result[1];
                       productNames.add(productName);
                       quantities.add(quantity);
                   }
                   model.addAttribute("type", "chart");
                   model.addAttribute("methodSource", "method3");
                   model.addAttribute("productNames", productNames);
                   model.addAttribute("quantities", quantities);
                   return "/product/thongKe/thongKe";
               } catch (Exception e) {
                   e.printStackTrace();
               }

           }
        }
        return "redirect:/account/login";
    }

    @PostMapping("/thong-ke-thang")
    public String getTopSellingProductTheoTuan(Model model,@RequestParam(name = "action") String action, @RequestParam(name = "startMonth") Integer start, @RequestParam(name = "endMonth") Integer end) {
     if(checkSecurity()){
         if(action.equals("search")){
             List<Object[]> topSellingProducts = orderDetailService.getTop10BesstSellingProductsByMonthRange(start, end);
             model.addAttribute("topSellingProducts", topSellingProducts);
             model.addAttribute("methodSource", "method2");
             model.addAttribute("type", "table");

             System.out.println("top"+topSellingProducts);
             return "/product/thongKe/thongKe";
         }
         else if(action.equals("view-chart")){
             List<Object[]> topSellingProducts = orderDetailService.getTop10BesstSellingProductsByMonthRange(start, end);
             List<String> productNames = new ArrayList<>();
             List<Long> quantities = new ArrayList<>();
             List<Integer> monthNames = new ArrayList<>();
             for (Object[] result : topSellingProducts) {
                 String productName = result[0].toString();
                 Integer monthName = (Integer) result[2];
                 Long quantity = (Long) result[1];
                 productNames.add(productName);
                 monthNames.add(monthName);
                 quantities.add(quantity);
             }
             model.addAttribute("type", "chart");
             model.addAttribute("methodSource", "method4");
             model.addAttribute("productNames", productNames);
             model.addAttribute("monthNames", monthNames);
             model.addAttribute("quantities", quantities);
             return "/product/thongKe/thongKe";
         }
     }
        return "redirect:/account/login";
    }

    @GetMapping("/view-tk")
    public String viewTk() {
        return "/product/thongKe/thongKe";

    }

    public boolean checkSecurity() {
        String userName = sessionService.get("username");
        System.err.println("checkSecurity" + userName);
        if (userName != null) {
            return true;
        }
        return false;
    }
}

//    @GetMapping("/chart-test")
//    public  String showChartTest(){
//        return "/product/chart/index";
//    }
//    @PostMapping("/view-chart")
//    public String showChart(Model model, @RequestParam(name = "startMonth") Integer start, @RequestParam(name = "endMonth") Integer end) {
//        List<Object[]> topSellingProducts = orderDetailService.getTop10BesstSellingProductsByMonthRange(start, end);
//        List<String> productNames = new ArrayList<>();
//        List<String> monthNames = new ArrayList<>();
//        List<Long> quantities = new ArrayList<>();
//        for (Object[] result : topSellingProducts) {
//            String productName = result[0].toString();
//            String monthName =  result[1].toString();
//            Long quantity = (Long) result[2];
//            productNames.add(productName);
//            monthNames.add(monthName);
//            quantities.add(quantity);
//        }
//        System.out.println(productNames);
//        System.out.println(monthNames);
//        System.out.println(quantities);
//        model.addAttribute("productNames", productNames);
//        model.addAttribute("monthNames", monthNames);
//        model.addAttribute("quantities", quantities);
//        return "/product/chart/index";
//    }