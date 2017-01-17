package mil.nga.giat.geowave.datastore.hbase;

import mil.nga.giat.geowave.core.store.entities.GeoWaveRowImpl;

public class HBaseRow extends
		GeoWaveRowImpl
{
	public HBaseRow(
			byte[] rowId,
			byte[] fieldMask,
			byte[] value ) {
		super(
				rowId,
				fieldMask,
				value);
		// TODO Auto-generated constructor stub
	}

}
