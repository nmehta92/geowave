package mil.nga.giat.geowave.core.store.entities;

import java.nio.ByteBuffer;

public class GeoWaveRowImpl implements
		GeoWaveRow
{
	protected final byte[] dataId;
	protected final byte[] adapterId;
	protected final byte[] index;
	protected final byte[] value;
	protected final byte[] fieldMask;
	protected final int numberOfDuplicates;
	
	public GeoWaveRowImpl(
			final byte[] rowId,
			final byte[] fieldMask,
			final byte[] value ) {
		final ByteBuffer metadataBuf = ByteBuffer.wrap(
				rowId,
				rowId.length - 12,
				12);
		final int adapterIdLength = metadataBuf.getInt();
		final int dataIdLength = metadataBuf.getInt();
		final int numberOfDuplicates = metadataBuf.getInt();

		final ByteBuffer buf = ByteBuffer.wrap(
				rowId,
				0,
				rowId.length - 12);
		final byte[] index = new byte[rowId.length - 12 - adapterIdLength - dataIdLength];
		final byte[] adapterId = new byte[adapterIdLength];
		final byte[] dataId = new byte[dataIdLength];
		buf.get(index);
		buf.get(adapterId);
		buf.get(dataId);

		this.dataId = dataId;
		this.adapterId = adapterId;
		this.index = index;
		this.numberOfDuplicates = numberOfDuplicates;
		
		this.fieldMask = fieldMask;
		this.value = value;
	}

	public GeoWaveRowImpl(
			final byte[] dataId,
			final byte[] adapterId,
			final byte[] index,
			final byte[] fieldMask,
			final byte[] value,
			final int numberOfDuplicates ) {
		this.dataId = dataId;
		this.adapterId = adapterId;
		this.index = index;
		this.fieldMask = fieldMask;
		this.value = value;
		this.numberOfDuplicates = numberOfDuplicates;
	}
	
	public byte[] getRowId() {
		final ByteBuffer buf = ByteBuffer.allocate(12 + dataId.length + adapterId.length + index.length);
		buf.put(index);
		buf.put(adapterId);
		buf.put(dataId);
		buf.putInt(adapterId.length);
		buf.putInt(dataId.length);
		buf.putInt(numberOfDuplicates);
		
		return buf.array();
	}

	@Override
	public byte[] getFieldMask() {
		return fieldMask;
	}

	@Override
	public byte[] getDataId() {
		return dataId;
	}

	@Override
	public byte[] getAdapterId() {
		return adapterId;
	}

	@Override
	public byte[] getIndex() {
		return index;
	}

	@Override
	public byte[] getValue() {
		return value;
	}
	
	@Override
	public int getNumberOfDuplicates() {
		return numberOfDuplicates;
	}
}
