package co.com.test.adapter.web.routers.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.test.adapter.web.controllers.health.impl.HealthController;
import co.com.test.adapter.web.controllers.trigger.impl.BridgeController;
import co.com.test.adapter.web.routers.IBridgeRouter;
import co.com.test.utility.ConstantManagers;
import co.com.test.utility.WebAdapter;

@WebAdapter
public class BridgeRouter implements IBridgeRouter {

	@Bean
	@Override
	public RouterFunction<ServerResponse> triggerProducts(BridgeController controller) {
		return RouterFunctions.route(RequestPredicates.GET(ConstantManagers.TRIGGERPATH)
				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), controller::find);
	}

	@Bean
	@Override
	public RouterFunction<ServerResponse> health(HealthController controller) {
		return RouterFunctions.route(RequestPredicates.GET(ConstantManagers.HEALTHPATH)
				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), controller::health);
	}

	@Bean
	public WebFluxConfigurer corsConfigurer() {
		return new WebFluxConfigurerComposite() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

}
