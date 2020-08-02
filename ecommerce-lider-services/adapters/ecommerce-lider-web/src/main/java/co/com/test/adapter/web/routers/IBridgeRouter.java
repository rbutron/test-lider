package co.com.test.adapter.web.routers;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.test.adapter.web.controllers.health.impl.HealthController;
import co.com.test.adapter.web.controllers.trigger.impl.BridgeController;

public interface IBridgeRouter {
	
	RouterFunction<ServerResponse> triggerProducts(BridgeController controller);
	
	RouterFunction<ServerResponse> health(HealthController controller);

}
