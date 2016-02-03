package updateTvInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;

import mainApp.ConfigurationDatabase;

public class EpisodesPersistantMySql extends EpisodesPersistant {

	private Connection conn;
	private HashMap<String, Episode> existingEpisodes;

	public EpisodesPersistantMySql(ConfigurationDatabase dbConf) {
		super(dbConf);
	}

	public void persistEpisodes(Episodes e) {

		Episode episode;

		Iterator<Episode> iterator = e.getIterator();

		while (iterator.hasNext()) {
			episode = iterator.next();

			if (!isEpisodeAlreadyExisting(episode))
				insertEpisode(episode);

		}

		if (conn != null)
			;
		try {
			conn.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private Connection getConnection() {
		if (conn == null) {
			try {

				Class.forName(dbConf.getDbDriver()).newInstance();
				conn = DriverManager.getConnection(
						dbConf.getDbURL() + dbConf.getDbName() + "?" + "user=" + dbConf.getDbUsername() + "&password=" + dbConf.getDbPassword());

			} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return conn;
	}

	private void insertEpisode(Episode episode) {
		// String sqlStatement = "INSERT INTO `tvSeriesEpisodes` "
		// + "(`tvSeries`, `season`, `episode`, `title`, `description`) VALUES "
		// + "('" + episode.tvSeriesId + "1', "
		// + "'" + episode.season + "', "
		// + "'" + episode.episode + "', "
		// + "'" + episode.title + "', "
		// + "'" + episode.description + "')";

		String sqlStatement = "INSERT INTO `allDB`.`tvSeriesEpisodes` (`tvSeries`, `season`, `episode`, `title`, `description`) VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement(sqlStatement);
			preparedStatement.setInt(1, episode.tvSeriesId);
			preparedStatement.setInt(2, episode.season);
			preparedStatement.setInt(3, episode.episode);
			preparedStatement.setString(4, episode.title);
			preparedStatement.setString(5, episode.description);

			preparedStatement.execute();

			existingEpisodes.put(generateKey(episode), episode);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private boolean isEpisodeAlreadyExisting(Episode e) {
		String sqlQueryText = "SELECT * FROM `tvSeriesEpisodes`";

		if (existingEpisodes == null) {
			existingEpisodes = new HashMap<String, Episode>();
			try {
				Connection conn = getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sqlQueryText);

				while (rs.next()) {
					Episode episode = new Episode();
					episode.tvSeriesId = rs.getInt("tvSeries");
					episode.season = rs.getInt("season");
					episode.episode = rs.getInt("episode");
					existingEpisodes.put(generateKey(episode), episode);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (existingEpisodes.containsKey(generateKey(e)))
			return true;

		return false;
	}

	private String generateKey(Episode e) {
		return e.tvSeriesId + ";" + e.season + ";" + e.episode;
	}

}
