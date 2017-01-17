package mil.nga.giat.geowave.datastore.hbase;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.RowMutations;

import mil.nga.giat.geowave.core.store.base.DataStoreEntryInfo;
import mil.nga.giat.geowave.core.store.entities.GeoWaveRow;
import mil.nga.giat.geowave.core.store.entities.NativeGeoWaveRowFactory;

public class HBaseRowFactory implements NativeGeoWaveRowFactory<RowMutations, Result>
{

	public HBaseRowFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Iterable<GeoWaveRow> fromIngestInfo(
			DataStoreEntryInfo ingestInfo ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeoWaveRow fromQueryResult(
			Result resultRow ) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RowMutations toMutation(GeoWaveRow nativeRow) {
		// TODO Auto-generated method stub
		return null;
	}

}
