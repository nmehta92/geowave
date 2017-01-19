package mil.nga.giat.geowave.core.store.entities;

public interface GeoWaveRow
{
	public byte[] getDataId();

	public byte[] getAdapterId();

	public byte[] getFieldMask();

	public byte[] getValue();

	public byte[] getIndex();

	public int getNumberOfDuplicates();
}
