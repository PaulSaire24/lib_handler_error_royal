package com.bbva.pisd.lib.r403.impl.repository.oracle;

import com.bbva.apx.exception.db.NoResultException;
import com.bbva.elara.utility.jdbc.JdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class LeadBD {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadBD.class);
    private JdbcUtils jdbcUtils;

    public LeadBD(JdbcUtils jdbcUtils) {
        this.jdbcUtils = jdbcUtils;
    }

    public List<Map<String, Object>> executeGetListASingleRow(String queryId, Map<String, Object> arguments) {
        LOGGER.info("***** LeadBD - executeGetListASingleRow START *****");
        LOGGER.info("***** LeadBD - executeGetListASingleRow | Executing {} QUERY", queryId);
        try {
            List<Map<String, Object>> response = this.jdbcUtils.queryForList(queryId, arguments);
            response.stream().forEach(map -> map.
                    forEach((key, value) -> LOGGER.info("[executeGetListASingleRow] Result -> Key {} with value: {}", key,value)));
            LOGGER.info("***** LeadBD - executeGetListASingleRow END *****");
            return response;
        } catch (NoResultException ex) {
            LOGGER.info("executeGetListASingleRow - There wasn't no result in query {}. Reason -> {}", queryId, ex.getMessage());
            return null;
        }
    }
}
