package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BulbController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public BulbDto main(Bulb bulb){
        System.out.println(bulb);

        Bulb bulbFromMap = Application.bulbsList.get(Application.bulbsList.indexOf(bulb));
        bulbFromMap.setCurrentState(bulb.getCurrentState());

        return new BulbDto(bulbFromMap.getCurrentState());
    }

    @GetMapping("/room/{roomId}")
    public String room(@PathVariable String roomId, Model model){
        int room = Integer.parseInt(roomId);

        model.addAttribute("initialValue", Application.bulbsList.get(room-1).getCurrentState());
        model.addAttribute("roomId", room);

        return "room";
    }
}
