package org.humber.student.controllers;

import org.humber.student.domain.Order;
import org.humber.student.domain.User;
import org.humber.student.repositories.entities.UserEntity;
import org.humber.student.services.OrderService;
import org.humber.student.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WebController {
    
    private final OrderService orderService;
    private final UserService userService;

    public WebController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/search-restaurants")
    public String searchRestaurants() {
        return "search-restaurants";
    }

    @GetMapping("/my-orders")
    public String myOrders(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        
        User user = userService.findByUsername(currentPrincipalName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + currentPrincipalName));

        List<Order> orders = orderService.getOrdersByUserId(user.getId());
        model.addAttribute("orders", orders);
        return "my-orders";
    }

    @GetMapping("/my-reviews")
    public String myReviews(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        User user = userService.findByUsername(currentPrincipalName)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + currentPrincipalName));

        List<Order> orders = orderService.getOrdersByUserId(user.getId());

        List<Map<String, String>> ordersWithReviews = orders.stream()
                .filter(order -> order.getReview() != null && !order.getReview().isEmpty())
                .map(order -> Map.of("id", order.getId().toString(), "review", order.getReview())).toList();

        model.addAttribute("ordersWithReviews", ordersWithReviews);
        return "my-reviews";
    }

    @GetMapping("/order/edit/{id}")
    public String editOrder(@PathVariable("id") Long id, Model model) {
        Order order = orderService.getOrder(id);
        model.addAttribute("order", order);
        return "edit-order";
    }

    @PostMapping("/orders/update")
    public String updateOrder(Order modifiedOrder) {
        var order = orderService.getOrder(modifiedOrder.getId());
        order.setRating(modifiedOrder.getRating());
        order.setReview(modifiedOrder.getReview());
        orderService.save(order);
        return "redirect:/my-orders"; 
    }
}