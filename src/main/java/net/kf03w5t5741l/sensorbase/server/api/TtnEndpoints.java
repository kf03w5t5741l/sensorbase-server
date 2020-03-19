package net.kf03w5t5741l.sensorbase.server.api;

import net.kf03w5t5741l.sensorbase.server.domain.device.TtnUplink;
import net.kf03w5t5741l.sensorbase.server.service.persistence.TtnUplinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ttn")
public class TtnEndpoints {
    @Autowired
    private TtnUplinkService ttnUplinkService;

    @GetMapping
    public Iterable<TtnUplink> getAllTtnUplinks() {
        return this.ttnUplinkService.findAll();
    }

    @PostMapping
    public void saveTtnUplink(@RequestBody String message) {
        TtnUplink uplink = new TtnUplink();
        uplink.setMessage(message);
        this.ttnUplinkService.save(uplink);
    }

    @DeleteMapping
    public void deleteAllTtnUplinks() {
        this.ttnUplinkService.deleteAll();
    }
}
