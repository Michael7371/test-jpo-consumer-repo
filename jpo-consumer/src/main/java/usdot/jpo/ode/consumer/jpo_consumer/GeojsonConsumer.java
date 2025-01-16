package usdot.jpo.ode.consumer.jpo_consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import usdot.jpo.ode.consumer.types.ProcessedPsmSchema;
import usdot.jpo.ode.consumer.types.PsmFeatureObject;

@Component
@Slf4j
public class GeojsonConsumer {
  private final ObjectMapper objectMapper;

  public GeojsonConsumer(ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
  }

  @KafkaListener(topics = "topic.ProcessedPsm", groupId = "${kafka.consumer.group-id}")
  public void consume(String message) {
    try {
      ProcessedPsmSchema processedPsmSchema =
          objectMapper.readValue(message, ProcessedPsmSchema.class);
      log.info("Received PSM Feature Object: {}", processedPsmSchema);
      // Add your processing logic here

    } catch (Exception e) {
      log.error("Error processing message from geojsonconverter topic: {}", e.getMessage(), e);
    }
  }
}
