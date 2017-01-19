package mil.nga.giat.geowave.core.store.entities;

import mil.nga.giat.geowave.core.store.base.DataStoreEntryInfo;

/**
 * Centralizes the creation of 'native' rows, both from adapters on ingest and
 * from query results, and the conversion of native rows to database mutations
 * 
 * @author kmiller
 *
 * @param <ResultType>
 */
public interface NativeGeoWaveRowFactory<MutationType, ResultType>
{
	public Iterable<GeoWaveRow> fromIngestInfo(
			DataStoreEntryInfo ingestInfo );

	public GeoWaveRow fromQueryResult(
			ResultType resultRow );

	public MutationType toMutation(
			GeoWaveRow nativeRow );
}
